package com.hrs.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hrs.userservice.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
}
