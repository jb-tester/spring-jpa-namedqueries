package com.mytests.spring.jpa.namedqueries;

import com.mytests.spring.jpa.namedqueries.model.SampleEntity;
import com.mytests.spring.jpa.namedqueries.repositories.SampleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 2/9/2022.</p>
 * <p>Project: spring-jpa-namedqueries</p>
 * *
 */
@Service
public class SampleServiceWithRepository {


    private final SampleRepository sampleRepository;

    public SampleServiceWithRepository(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public void runQueryFromEntity() {
        System.out.println("====== named query from entity via repository =====");
        for (SampleEntity sample : sampleRepository.samplesByName("new_sample")) {
            System.out.println(sample);
        }

        System.out.println("===================");
    }
    public void runQueryFromXml() {
        System.out.println("====== named query from orm.xml via repository =====");
        for (SampleEntity sample : sampleRepository.locateSamplesByName("new_sample")) {
            System.out.println(sample);
        }
        for (String sample : sampleRepository.namesByColor("red")) {
            System.out.println(sample);
        }
        System.out.println("===================");
    }

    ;
}
