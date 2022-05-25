package com.employees.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee_worked_hours")
public class EmpWorkedHours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_employee",insertable = false,updatable = false)
    private Employee employeeId;

    @Column(name = "id_employee")
    private Integer idEmployee;

    private Integer workedHours;

    @Column(unique = true)
    private LocalDate workedDate;
}
