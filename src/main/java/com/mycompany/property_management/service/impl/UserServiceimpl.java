package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optUe = userRepository.findByOwneremail(userDTO.getOwneremail());
        if (optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Already exist");
            errorModel.setMessage("Use different email");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.ConvertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.ConvertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String Owneremail, String password) {
        UserDTO userDTO =null;
       Optional<UserEntity> optionalUserEntity= userRepository.findByOwneremailAndPassword(Owneremail,password);
       if (optionalUserEntity.isPresent()){
           userDTO = userConverter.ConvertEntitytoDTO(optionalUserEntity.get());
       }
       else {
           List<ErrorModel> errorModelList = new ArrayList<>();
           ErrorModel errorModel = new ErrorModel();
           errorModel.setCode("INVALID_LOGIN");
           errorModel.setMessage("invalid email or password");

           errorModelList.add(errorModel);
           throw new BusinessException(errorModelList);
       }
        return userDTO;
    }
}
