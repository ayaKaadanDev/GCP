package org.closure.gcp.repositories;

import java.util.Optional;

import org.closure.gcp.entities.CollageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollageRepo extends JpaRepository<CollageEntity,Integer>{
    
    Optional<CollageEntity> findByCollageName(String collageName);
}
