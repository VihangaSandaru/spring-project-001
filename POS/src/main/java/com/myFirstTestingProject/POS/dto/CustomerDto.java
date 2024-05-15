package com.myFirstTestingProject.POS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private double salary;
}
