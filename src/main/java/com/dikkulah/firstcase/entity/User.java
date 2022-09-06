package com.dikkulah.firstcase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;


    @OneToMany(mappedBy = "user")
    private List<Comment> comments= new ArrayList<>();



}
