package com.mytests.spring.jpa.namedqueries.repositories;

import com.mytests.spring.jpa.namedqueries.model.SampleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 10/11/2021.</p>
 * <p>Project: spring-jpa-namedqueries</p>
 * *
 */
public interface SampleRepository extends CrudRepository<SampleEntity, Integer> {
   // named queries from orm.xml
    List<SampleEntity> locateSamplesByName(String name);
    List<String> namesByColor(String color);

    // named query from entity
    List<SampleEntity> samplesByName(String name);


    @Query("select sample.sample as sample from SampleEntity sample")
    List<String> foo();
}
