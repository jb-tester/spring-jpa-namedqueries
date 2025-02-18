package com.mytests.spring.jpa.namedqueries.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * *
 * <p>Created by irina on 10/11/2021.</p>
 * <p>Project: spring-jpa-namedqueries</p>
 * *
 */
@Entity
@Table(name = "sample", schema = "jbtests")
@NamedQuery(name = "SampleEntity.samplesByName", query = "select sample from SampleEntity sample where sample.sample = :name")
public class SampleEntity {
    private int id;
    private Integer version;
    private String sample;
    private String color;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "sample")
    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleEntity that = (SampleEntity) o;
        return id == that.id && Objects.equals(version, that.version) && Objects.equals(sample, that.sample) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, sample, color);
    }

    @Override
    public String toString() {
        return "SampleEntity{" +
                "id=" + id +
                ", version=" + version +
                ", sample='" + sample + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
