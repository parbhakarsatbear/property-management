package com.mycompany.Propertymanagement.repository;

import com.mycompany.Propertymanagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {}
