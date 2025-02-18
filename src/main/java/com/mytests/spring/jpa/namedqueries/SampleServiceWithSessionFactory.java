package com.mytests.spring.jpa.namedqueries;

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
public class SampleServiceWithSessionFactory {

    final
    SessionFactory sessionFactory;

    public SampleServiceWithSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void runQueryFromEntity() {
        Session session = sessionFactory.openSession();
        System.out.println("====== named query from entity via sessionFactory =====");
        session.getNamedQuery("SampleEntity.samplesByName").setParameter("name", "new_sample").list().forEach(System.out::println);
        System.out.println("===================");
    }
    public void runQueryFromXml() {
        Session session = sessionFactory.openSession();
        System.out.println("====== named query from orm.xml via sessionFactory =====");
        session.getNamedQuery("SampleEntity.locateSamplesByName").setParameter(1,"new_sample").list().forEach(System.out::println);
        System.out.println("===================");
    }

    ;
}
