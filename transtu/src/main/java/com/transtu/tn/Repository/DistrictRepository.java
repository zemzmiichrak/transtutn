package com.transtu.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transtu.tn.Entity.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
  
}
