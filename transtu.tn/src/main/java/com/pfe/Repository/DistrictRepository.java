package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
  
}