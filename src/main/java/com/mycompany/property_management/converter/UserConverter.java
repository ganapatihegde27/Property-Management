package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity ConvertDTOtoEntity(UserDTO userDTO){
        UserEntity userentity = new UserEntity();
        userentity.setOwneremail(userDTO.getOwneremail());
        userentity.setPhone(userDTO.getPhone());
        userentity.setOwnername(userDTO.getOwnername());
        userentity.setPassword(userDTO.getPassword());
        return userentity;

    }

    public UserDTO ConvertEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwneremail(userEntity.getOwneremail());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setOwnername(userEntity.getOwnername());
        return userDTO;

    }


}
