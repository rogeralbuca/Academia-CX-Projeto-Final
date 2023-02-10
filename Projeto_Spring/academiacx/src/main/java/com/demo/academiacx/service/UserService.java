package com.demo.academiacx.service;

import com.demo.academiacx.handler.exceptions.ParametroInvalidoException;
import com.demo.academiacx.handler.exceptions.RecursoNaoEncontradoException;
import com.demo.academiacx.model.UserModel;
import com.demo.academiacx.model.dto.user.UserDto;
import com.demo.academiacx.model.dto.user.UserRequestDto;
import com.demo.academiacx.model.dto.user.UserResponseDto;
import com.demo.academiacx.repository.UserRepository;
import com.demo.academiacx.utils.ValidacaoUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.demo.academiacx.config.security.WebSecurityConfig.passwordEncoder;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public List<UserResponseDto> findAll() {
        List<UserModel> userModels = userRepository.findAll();


        return modelMapper.map(userModels, new TypeToken<List<UserResponseDto>>() {
        }.getType());
    }

    public UserDto findById(UserModel userModel) {

        if (userModel == null) {
            throw new ParametroInvalidoException("A User Model deve informada");

        }

        if (userModel.getId() == null) {
            throw new ParametroInvalidoException("A User Model deve conter um id");

        }

        try {
            userModel = userRepository.findById(userModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }


        return modelMapper.map(userModel, UserDto.class);
    }


    public UserModel findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");

        }

        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return userModel;
    }
    public UserModel findUserModelById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        UserModel userModel = new UserModel();
        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado");
        }

        return userModel;
    }
    public UserResponseDto insert(UserDto userDto) {

        ValidarUser(userDto);

        UserModel userModel = new UserModel(userDto);
       //userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));


        userModel = userRepository.save(userModel);


        UserResponseDto result = new UserResponseDto(userModel);


        return result;
    }

    public UserModel update(UserModel userModel) {

            findById(userModel);

            ValidarUser(new UserDto(userModel));

        return userRepository.save(userModel);
    }

    public boolean delete(Long id) {

        findById(id);

        userRepository.deleteById(id);

        return true;
    }

    public UserDto findByNameOrEmailOrId(String name, String email, Long id, String username) {

        Optional<UserModel> userModel = userRepository.findByNomeOrEmailOrIdOrUsername(id, name, email, username);

        if (userModel.isPresent()) {
            return modelMapper.map(userModel, UserDto.class);
            //return userModel.stream().findFirst().get();
        } else {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
    }

    public UserDto buscarPorId(Long id) {

        Optional<UserModel> userModel = userRepository.buscaPorId(id);

        if (userModel.isPresent())
        {
            return new UserDto(userModel.get());
        }else {
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }
    }

    public void ValidarUser(UserDto userDto){
        //ValidacaoUtils.validarVazio(userDto.getNome(), "O nome é obrigatório");
        //ValidacaoUtils.validarEmail(userDto.getEmail(), "O email inserido é inválido");
    }

    public UserResponseDto findByUsernameAndPassword(UserRequestDto usuario) {

        ValidacaoUtils.validarVazio(usuario.getUsername(), "O username é obrigatório!");
        ValidacaoUtils.validarVazio(usuario.getPassword(), "A senha é obrigatória!");

        if (userRepository.findByUsername(usuario.getUsername()).isEmpty()) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }

        UserModel userModel = userRepository.findByUsernameAndPassword(usuario.getUsername(),
                usuario.getPassword());

        if (userModel.equals(null)) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado");
        }
        return new UserResponseDto(userModel);
    }

}
