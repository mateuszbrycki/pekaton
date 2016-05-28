package com.springiscoming.web;

import com.springiscoming.model.Student;
import com.springiscoming.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class DefaultController {

    @Inject
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Student addNewStudent() {
        Student student = new Student("mateusz", "ostatni");

        studentService.saveStudent(student);

        return student;
    }
}
