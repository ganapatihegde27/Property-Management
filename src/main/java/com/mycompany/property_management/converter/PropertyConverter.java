package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setPrice(propertyDTO.getPrice());
        pe.setOwnerName(propertyDTO.getOwnerName());
        return pe;
    }

    public PropertyDTO convertEntitytoDTO (PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId((propertyEntity.getId()));
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        return propertyDTO;
    }
}
