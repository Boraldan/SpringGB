package com.example.sem3HomeTask.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "age")
    private int age;

//    @Column(name = "email")
    private String email;

}
