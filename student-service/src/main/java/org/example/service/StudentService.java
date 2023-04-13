package org.example.service;

import org.example.dto.request.StudentRequest;
import org.example.dto.response.GenericResponse;
import org.example.dto.response.StudentResponse;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService {
        @Autowired
    StudentRepository studentRepository;

        public GenericResponse register(StudentRequest studentRequest){
            Optional<Student> existingStudent = studentRepository.findById(studentRequest.getStudent_id());
            if (existingStudent.isPresent()) {
                return new GenericResponse(Constants.ERROR, "A student with the same Id already exists");
            }
           Student student= Student.builder()
                    .student_id(studentRequest.getStudent_id())
                    .student_details(studentRequest.getStudent_details()).build();
           studentRepository.save(student);
           return new GenericResponse(Constants.SUCCESS,"Student Added Successfully");
        }

        public List<StudentResponse> getAllStudents(){
            return studentRepository.findAll().stream()
                    .map(student -> StudentResponse
                            .builder()
                            .student_id(student.getStudent_id())
                            .student_details(student.getStudent_details()).build()).collect(Collectors.toList());
        }

        public Student getStudent(String id){
            return studentRepository.findById(id)
                    .map(student -> Student.builder()
                            .student_id(student.getStudent_id())
                            .student_details(student.getStudent_details())
                            .build())
                    .get();
        }
        public GenericResponse updateStudent(StudentRequest studentRequest){
            Optional<Student> updatedstudent=studentRepository.findById(studentRequest.getStudent_id());
            if(updatedstudent.isPresent()) {
                Student student = Student.builder()
                        .student_id(studentRequest.getStudent_id())
                        .student_details(studentRequest.getStudent_details()).build();
                studentRepository.save(student);
                return new GenericResponse(Constants.SUCCESS, "Student updated Successfully");
            }
            else{
                return new GenericResponse(Constants.ERROR, "Student not available");
            }
        }

        public GenericResponse deleteStudent(String id){
            studentRepository.deleteById(id);
            return new GenericResponse(Constants.SUCCESS,"Student deleted successfully");
        }
}
