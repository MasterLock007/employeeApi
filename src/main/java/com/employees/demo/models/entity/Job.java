package com.employees.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "jobs")
public class Job implements Serializable {
    private static final long serialVersionUID = -6992168489249391317L;

    @Id
    @Column(name = "id_job")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double salary;
}
