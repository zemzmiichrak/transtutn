package com.transtu.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transtu.tn.Entity.MoyenTransport;

@Repository
public interface MoyenTransportRepository extends JpaRepository<MoyenTransport, Long> {
   
}