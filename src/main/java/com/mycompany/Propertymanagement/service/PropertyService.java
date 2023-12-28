package com.mycompany.Propertymanagement.service;

import com.mycompany.Propertymanagement.dto.PropertyDTO;
import com.mycompany.Propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {


    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO>  getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long Id);

}
