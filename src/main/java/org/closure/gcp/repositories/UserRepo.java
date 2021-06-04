package org.closure.gcp.repositories;

import java.util.Optional;

import org.closure.gcp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    
    Optional<UserEntity> findByEmail(String email);
}
