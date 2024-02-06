package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
}
