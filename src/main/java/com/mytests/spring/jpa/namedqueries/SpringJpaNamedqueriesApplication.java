package com.mytests.spring.jpa.namedqueries;

import com.mytests.spring.jpa.namedqueries.model.SampleEntity;
import com.mytests.spring.jpa.namedqueries.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaNamedqueriesApplication implements CommandLineRunner {
    @Autowired
    private SampleRepository sampleRepo;
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaNamedqueriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (SampleEntity sample : sampleRepo.locateSamplesByName("new_sample")) {
            System.out.println(sample);
        }
        for (String sample : sampleRepo.namesByColor("red")) {
            System.out.println(sample);
        }
    }
}
