package com.example.school.Controller;

import com.example.school.Model.Students;
import com.example.school.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/school/students")
@AllArgsConstructor
public class StudentsController {

    private  final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents())     ;
    }



    @PostMapping("/add")
    public ResponseEntity addStudent( @RequestBody @Valid Students students){
        studentService.addStudents(students);
        return ResponseEntity.status(200).body("added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Students student){
        studentService.updateStudents(id,student);
        return ResponseEntity.status(200).body("updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }

    @PutMapping("/assign/{courseId}/{studentsId}")
    public ResponseEntity assignCoursesstToStudents(@PathVariable Integer courseId,@PathVariable Integer studentsId){

        studentService.assigCourseeTostudents(courseId,studentsId);
        return ResponseEntity.status(200).body("assigend");
    }

    @GetMapping("/student-list/{courseId}")
    public ResponseEntity ListOfStudents(Integer courseId){

        return ResponseEntity.status(200).body(studentService.studentsList(courseId))   ;
    }


    @PutMapping("/changMajor/{studentsId}/{nwemajor}")
    public ResponseEntity changMajor(@PathVariable Integer studentsId, @PathVariable String nwemajor){

        studentService.setMajor(studentsId,nwemajor);
        return ResponseEntity.status(200).body("set done");
    }
}
