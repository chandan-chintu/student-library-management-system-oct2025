package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.saveStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Object findStudentById(@PathVariable int id){
        try {
            Student student = studentService.getStudentById(id);
            return student;
        } catch (Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            return "Exception occurred : "+e.getMessage();
        }
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/findByPage")
    public List<Student> findAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList = studentService.getStudentsByPage(pageNo, pageSize);
        return studentList;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteById(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id, studentRequestDto);
        return response;
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
        Student student = studentService.getStudentByEmail(email);
        return student;
    }

    @GetMapping("/findByDept")
    public List<Student> findByDept(@RequestParam String dept){
        List<Student> studentList = studentService.getStudentByDept(dept);
        return studentList;
    }


}
