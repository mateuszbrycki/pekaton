package com.springiscoming.web;

import com.springiscoming.model.Student;
import com.springiscoming.service.StudentService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class DefaultController {

    @Inject
    private StudentService studentService;

    @GET
    @Path("/default")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewStudent() {
        Student student = new Student("mateusz", "ostatni");

        studentService.saveStudent(student);

        return Response.status(200).entity(student).build();
    }
}
