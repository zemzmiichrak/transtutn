package com.transtu.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transtu.tn.Entity.TypeTransport;
@Repository
public interface TypeTransportRepository extends JpaRepository<TypeTransport, Long> {
    
}