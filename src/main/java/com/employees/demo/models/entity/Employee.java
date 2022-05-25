package com.employees.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = -6000102354141498167L;

    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_gender",insertable = false,updatable = false)
    private Gender genderId;

    @Column(name = "id_gender")
    private Integer idGender;

    @ManyToOne
    @JoinColumn(name = "id_job",insertable = false,updatable = false)
    private Job jobId;

    @Column(name = "id_job")
    private Integer idJob;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String lastName;

    private LocalDate birthdate;


}
