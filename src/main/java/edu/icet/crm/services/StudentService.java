package edu.icet.crm.services;

import edu.icet.crm.dto.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudent();
    boolean removeStudent(Long studentId);
}
