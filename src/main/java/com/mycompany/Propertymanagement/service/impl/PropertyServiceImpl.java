package com.mycompany.Propertymanagement.service.impl;

import com.mycompany.Propertymanagement.convertor.PropertyConvertor;
import com.mycompany.Propertymanagement.dto.PropertyDTO;
import com.mycompany.Propertymanagement.entity.PropertyEntity;
import com.mycompany.Propertymanagement.repository.PropertyRepository;
import com.mycompany.Propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConvertor propertyConvertor;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConvertor.convertDTOtoEntity(propertyDTO);

        pe = propertyRepository.save(pe);
        PropertyDTO dto = propertyConvertor.convertEntitytoDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps= ( List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for(PropertyEntity pe : listOfProps){
            PropertyDTO propertyDTO = propertyConvertor.convertEntitytoDTO(pe);
            propertyDTOList.add(propertyDTO);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optPropertyEntity= propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optPropertyEntity.isPresent()){
            PropertyEntity pe = optPropertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());


            propertyRepository.save(pe);
            dto = propertyConvertor.convertEntitytoDTO(pe);

        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long Id) {
        Optional<PropertyEntity> optPropertyEntity= propertyRepository.findById(Id);
        PropertyDTO dto=null;
        if(optPropertyEntity.isPresent()){
            PropertyEntity pe = optPropertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            dto = propertyConvertor.convertEntitytoDTO(pe);

        }
        return dto;
    }


}
