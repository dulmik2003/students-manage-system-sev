package edu.icet.crm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Student;
import edu.icet.crm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ObjectMapper mapper;
    @PostMapping("/add")
    Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/get-all")
    List<Student> getAllStudent() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return studentService.getAllStudent();
    }

    @DeleteMapping("/delete/{studentId}")
    Map removeStudent(@PathVariable Long studentId) {
        boolean isRemoved = studentService.removeStudent(studentId);

        if (isRemoved) {
            return Collections.singletonMap("status", "student removed");
        }
        return Collections.singletonMap("status", "Failed.");
    }

    @PatchMapping("/update")
    Student updateStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
