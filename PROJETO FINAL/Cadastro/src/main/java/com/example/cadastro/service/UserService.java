package com.example.cadastro.service;

import com.example.cadastro.handler.exceptions.ParametroInvalidoException;
import com.example.cadastro.handler.exceptions.RecursoNaoEncontradoException;
import com.example.cadastro.model.UserModel;
import com.example.cadastro.model.dto.UserDto;
import com.example.cadastro.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> findall(){
        List<UserModel> userModel = userRepository.findAll();

        return modelMapper.map(userModel, new TypeToken<List<UserDto>>(){
        }.getType());
    }

    public UserDto findById(UserModel userModel) {

        if (userModel == null) {
            throw new RecursoNaoEncontradoException("Conteúdo não encontrado");

        }

        if (userModel.getId() == null) {
            throw new RecursoNaoEncontradoException("Conteúdo não encontrado");

        }

        try {
            userModel = userRepository.findById(userModel.getId()).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Conteúdo não encontrado");
        }

        return modelMapper.map(userModel, UserDto.class);
    }

    public UserDto findById(Long id) {

        if(id == null){
            throw new RecursoNaoEncontradoException("Conteúdo não encontrado");
        }

        UserModel userModel;

        try {
            userModel = userRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Conteúdo não encontrado");
        }

        return modelMapper.map(userModel, UserDto.class);
    }

    public UserDto insert(UserDto userDto) {
        userDto.setId(null);

//        validarInsert(userDto);

        UserModel userModel = userRepository.save(modelMapper.map(userDto, UserModel.class));

        return modelMapper.map(userModel,UserDto.class);
    }

    public UserDto update(UserDto userDto) {

        if(!userRepository.existsById(userDto.getId())){
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }

        UserModel userModel = userRepository.save(modelMapper.map(userDto, UserModel.class));

        return modelMapper.map(userModel,UserDto.class);
    }

    public boolean delete(Long id){

        UserModel userModel = new UserModel();

        if(!userRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Id não encontrado");
        }

        userRepository.deleteById(id);

        return true;
    }

//    public void validarInsert(UserDto userDto){
//
//        if(userDto.getNome().isEmpty()){
//            throw new ParametroInvalidoException("Cep inválido, digite outro");
//        }
//
//        if(userDto.getNome() == null){
//            throw new ParametroInvalidoException("Nome inválido, digite outro");
//        }
//
//        if(userDto.getUsername() == null || userRepository.findByUsername(userDto.getUsername()).isPresent()){
//            throw new ParametroInvalidoException("Username inválido, digite outro");
//        }
//
//        if(userDto.getPassword() == null){
//            throw new ParametroInvalidoException("Senha inválida, digite outro");
//        }
//    }
}
