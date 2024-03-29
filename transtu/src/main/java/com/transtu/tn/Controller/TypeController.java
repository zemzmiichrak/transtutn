package com.transtu.tn.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transtu.tn.Entity.TypeTransport;
import com.transtu.tn.Repository.TypeTransportRepository;

@RestController
@RequestMapping("/api/v1/type")
public class TypeController {

    private final TypeTransportRepository typeTransportRepository;

   
    public TypeController(TypeTransportRepository typeTransportRepository) {
        this.typeTransportRepository = typeTransportRepository;
    }

    @GetMapping(path= "/getAll")
    public List<TypeTransport> listerTypes() {
        return typeTransportRepository.findAll();
    }
}
