package com.transtu.tn.Service;


import org.springframework.stereotype.Service;

import com.transtu.tn.Entity.TypeTransport;
import com.transtu.tn.Repository.TypeTransportRepository;

import jakarta.transaction.Transactional;

@Service
public class TypeService {
    
    private final TypeTransportRepository typeTransportRepository;


    public TypeService(TypeTransportRepository typeTransportRepository) {
        this.typeTransportRepository = typeTransportRepository;
    }

    @Transactional
    public void createTypeTransports() {
        TypeTransport tgm = new TypeTransport(null, "TGM", null);
        TypeTransport metro = new TypeTransport(null, "Metro", null);
        TypeTransport bus = new TypeTransport(null, "Bus", null);
        
        typeTransportRepository.save(tgm);
        typeTransportRepository.save(metro);
        typeTransportRepository.save(bus);
    }

	public TypeTransport getTypeTransportById(Long typeTransportId) {
		// TODO Auto-generated method stub
		return null;
	}
}