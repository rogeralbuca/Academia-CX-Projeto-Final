package com.academiacx.projetofinal.service;

import com.academiacx.projetofinal.handler.exceptions.ParametroInvalidoException;
import com.academiacx.projetofinal.model.CadastroUsuario;
import com.academiacx.projetofinal.model.LoginUsuario;
import com.academiacx.projetofinal.repository.UsuarioRepository;
import com.academiacx.projetofinal.utils.ValidacaoUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<CadastroUsuario> CadastrarUsuario(CadastroUsuario usuario) {

        validateSave(usuario);

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent() && usuario.getId() == 0) {
            return null;

        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        usuarioRepository.save(usuario);


        return null;
    }
    public Optional<LoginUsuario> Logar(Optional<LoginUsuario> userLogin) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<CadastroUsuario> usuario = usuarioRepository.findByEmail(userLogin.get().getEmail());


        if (usuario.isPresent()) {
            if (encoder.matches(userLogin.get().getSenha(), usuario.get().getSenha())) {

                String auth = userLogin.get().getEmail() + ":" + userLogin.get().getSenha();

                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

                String authHeader = "Basic " + new String(encodedAuth);

                userLogin.get().setToken(authHeader);
                userLogin.get().setUsername(usuario.get().getUsername());
                userLogin.get().setEmail(usuario.get().getEmail());
                userLogin.get().setSenha(usuario.get().getSenha());
                userLogin.get().setNome(usuario.get().getNome());
                userLogin.get().setId(usuario.get().getId());


                return userLogin;

            }
        }

        return userLogin;
    }

    private void validateSave(CadastroUsuario usuario) {
        ValidacaoUtils.validarTamanhoMinimo(usuario.getNome(), 3, "Nome deve conter 3 caracteres");

        ValidacaoUtils.validarTamanhoMinimo(usuario.getUsername(), 5, "O username deve conter 5 caracteres no minimo");

        ValidacaoUtils.PasswordValidator(usuario.getSenha(), "minimo de 8 caracteres, incluir ao menos uma letra maiuscula, minuscula, digito e caractere especial");

        ValidacaoUtils.EmailValidator(usuario.getEmail(), "exemplo email valido: hello@example.com");


        if (usuario.getNome() == null) {
            throw new ParametroInvalidoException("O nome deve ser informado");
        }
        if (usuario.getUsername() == null) {
            throw new ParametroInvalidoException("O username deve ser informado");
        }
        if (usuario.getSenha() == null) {
            throw new ParametroInvalidoException("A senha deve ser informada");
        }
        if (usuario.getEmail() == null) {
            throw new ParametroInvalidoException("O email deve ser informado");
        }


    }
}
