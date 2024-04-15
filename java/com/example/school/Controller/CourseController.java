package com.example.school.Controller;

import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/school/course")
@AllArgsConstructor
public class CourseController {
    private  final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getCourse()) ;
    }



    @PostMapping("/add/{teacheId}")
    public ResponseEntity addCourse( @PathVariable int teacheId,@RequestBody @Valid Course course){
        courseService.addCourse(teacheId,course);
        return ResponseEntity.status(200).body("added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id,@RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body("updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @GetMapping("/get_by_name/{id}")
    public ResponseEntity getCourseByTecherName(@PathVariable int id){

        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }



}
