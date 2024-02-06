package edu.icet.crm.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Student;
import edu.icet.crm.repository.StudentRepository;
import edu.icet.crm.services.StudentService;
import edu.icet.crm.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Student createStudent(Student student) {
        //Dto To Entity Conversion
        StudentEntity entity = mapper.convertValue(student, StudentEntity.class);

        //Save Data To The Database
        StudentEntity pulledEntity = studentRepository.save(entity);
        return mapper.convertValue(pulledEntity, Student.class);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student>list = new ArrayList<>();
        Iterable<StudentEntity> studentList = studentRepository.findAll();

        Iterator<StudentEntity> iterator = studentList.iterator();

        while (iterator.hasNext()) {
            StudentEntity entity = iterator.next();
            Student student = mapper.convertValue(entity, Student.class);
            list.add(student);
        }

        return list;
    }

    @Override
    public boolean removeStudent(Long studentId) {
        Optional<StudentEntity> entityOptional = studentRepository.findById(studentId);

        if (entityOptional.isPresent()) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}
