package com.transtu.tn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.transtu.tn.Entity.Ligne;

@Repository
@EnableJpaRepositories
public interface LigneRepository extends JpaRepository<Ligne, Long> {
    boolean existsByCodeOrLabel(String code, String label);
}