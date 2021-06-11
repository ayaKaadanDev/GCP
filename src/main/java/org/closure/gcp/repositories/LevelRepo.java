package org.closure.gcp.repositories;

import java.util.Optional;

import org.closure.gcp.entities.LevelEntity;
import org.closure.gcp.models.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  LevelRepo extends JpaRepository<LevelEntity,Integer>{
    
    Optional<LevelEntity> findByEmail(String email);
     
    }


