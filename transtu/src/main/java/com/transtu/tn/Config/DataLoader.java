package com.transtu.tn.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import com.transtu.tn.Repository.DistrictRepository;
import com.transtu.tn.Service.DistrictService;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (districtRepository.count() == 0) {
            districtService.createDistricts();
        } else {
            System.out.println("Districts already exist, skipping creation.");
        }
    }
}
