package com.employees.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "genders")
public class Gender implements Serializable {
    private static final long serialVersionUID = 4971755327586434145L;

    @Id
    @Column(name = "id_gender")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
