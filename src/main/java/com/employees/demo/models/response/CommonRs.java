package com.employees.demo.models.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CommonRs implements Serializable {
    private static final long serialVersionUID = 6435945131851492431L;
    private String id;
    private boolean sucess;
}
