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
    private SampleServiceWithSessionFactory sampleServiceWithSessionFactory;
    @Autowired
    private SampleServiceWithRepository sampleServiceWithRepository;
    @Autowired
    private SampleRepository sampleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaNamedqueriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // queries from orm.xml - repository
        sampleServiceWithRepository.runQueryFromXml();

        // queries from orm.xml - sessionFactory
        sampleServiceWithSessionFactory.runQueryFromEntity();

        // queries from entity - jpa repository
        sampleServiceWithRepository.runQueryFromEntity();

        // queries from entity - sessionFactory
        sampleServiceWithSessionFactory.runQueryFromXml();

        // explicit @Query
        System.out.println(sampleRepository.foo());
    }
}
