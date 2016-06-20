package com.springiscoming.service.student;

import com.springiscoming.model.student.Student;
import com.springiscoming.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }
}
