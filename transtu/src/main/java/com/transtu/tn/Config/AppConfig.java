package com.transtu.tn.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.transtu.tn.Repository.TypeTransportRepository;
import com.transtu.tn.Service.TypeService;

@Configuration
public class AppConfig {

    @Autowired
    private TypeService typeService;

    @Bean
    public CommandLineRunner commandLineRunner(TypeTransportRepository typeTransportRepository) {
        return args -> {
            if (typeTransportRepository.count() == 0) {
                typeService.createTypeTransports();
            }
        };
    }
}