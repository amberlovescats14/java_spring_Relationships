package com.amber.relationship.repos;


import com.amber.relationship.model.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepo extends JpaRepository<PetOwner, Long> {
}
