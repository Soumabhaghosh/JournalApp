package com.marao.maraoSpring.repository;
import com.marao.maraoSpring.entity.entityClass;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface repos extends MongoRepository<entityClass, ObjectId> {

}
