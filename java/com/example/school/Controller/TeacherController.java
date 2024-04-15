package com.example.school.Controller;

import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/school/teachr")
@AllArgsConstructor
public class TeacherController {
    public final TeacherService teacherService;



    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
return ResponseEntity.status(200).body(teacherService.getTeacher())     ;
    }



    @PostMapping("/add")
    public ResponseEntity addTeacher( @RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id,@RequestBody @Valid Teacher teacher){
       teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @GetMapping("/get_details/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }

}
