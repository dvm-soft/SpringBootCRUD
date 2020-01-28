package com.dvm.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(appliesTo = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private Boolean gender;
    private LocalDate birthday;

    public Person(String firstName, String midName, String lastName, Boolean gender, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, insertable = true, updatable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "mid_name", nullable = true, insertable = true, updatable = true)
    public String getMidName() {
        return midName;
    }

    public void setMidName(String surName) {
        this.midName = surName;
    }

    @Column(name = "last_name", nullable = false, insertable = true, updatable = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "gender", nullable = true, insertable = true, updatable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean sex) {
        this.gender = sex;
    }

    @Column(name = "birthday", nullable = true, insertable = true, updatable = true)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';

    }
}