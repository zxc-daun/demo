package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    Long id;
    String name;
}
