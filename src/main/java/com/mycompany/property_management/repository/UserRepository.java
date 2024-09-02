package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long > {

    Optional<UserEntity> findByOwneremailAndPassword(String owneremail, String password);
    Optional<UserEntity> findByOwneremail(String owneremail);

}
