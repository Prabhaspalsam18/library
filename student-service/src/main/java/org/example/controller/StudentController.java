package org.example.controller;

import org.example.dto.request.StudentRequest;
import org.example.dto.response.GenericResponse;
import org.example.dto.response.StudentResponse;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public GenericResponse register(@RequestBody StudentRequest studentRequest){
        return studentService.register(studentRequest);
    }
    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){
        return studentService.getStudent(id);
    }

    @PutMapping
    public GenericResponse updateStudent(@RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentRequest);
    }
    @DeleteMapping("/{id}")
    public GenericResponse deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
