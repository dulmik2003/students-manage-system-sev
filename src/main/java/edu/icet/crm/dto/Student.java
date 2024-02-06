package edu.icet.crm.dto;

import lombok.Data;

@Data
public class Student {
    Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
}
