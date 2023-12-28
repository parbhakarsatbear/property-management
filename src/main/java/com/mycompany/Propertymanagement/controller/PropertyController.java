package com.mycompany.Propertymanagement.controller;

import com.mycompany.Propertymanagement.dto.PropertyDTO;
import com.mycompany.Propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello(){return "Hello";}

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO=propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties/showall")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){

        System.out.println(dummy);

        List<PropertyDTO> propertyDTOList= propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyDTOList,HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        PropertyDTO dto = propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(dto,HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{Id}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long Id){
        PropertyDTO dto = propertyService.updatePropertyDescription(propertyDTO,Id);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(dto,HttpStatus.OK);
        return responseEntity;
    }
}
