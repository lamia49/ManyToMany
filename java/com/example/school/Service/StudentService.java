package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Students;
import com.example.school.Rebositry.CourseRebositry;
import com.example.school.Rebositry.StudentRebositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRebositry studentRebositry;
    private  final CourseRebositry courseRebositry;
    public List getStudents(){
        return studentRebositry.findAll();
    }

    public void addStudents(Students students){
        studentRebositry.save(students);
    }

    public void  updateStudents(Integer id ,Students students){

        Students students1= studentRebositry.findStudentsById(id);
        if(students1==null){
            throw new ApiException("id not found");
        }
        students1.setName(students.getName());
        students1.setAge(students.getAge());
        students1.setMajor(students.getMajor());
        studentRebositry.save(students1);
    }


    public void  delete(Integer id){
        Students students= studentRebositry.findStudentsById(id);
        if(students==null){
            throw new ApiException("id not found");
        }
        studentRebositry.delete(students);
    }


    public void assigCourseeTostudents(Integer courseId,Integer studentsId){
        Students students= studentRebositry.findStudentsById(studentsId);
        Course course1=courseRebositry.findCourseById(courseId);
        if(students==null||course1==null){
            throw new ApiException("can,t assign");
        }
students.getCourseSet().add(course1);
course1.getStudentsSet().add(students);
studentRebositry.save(students);
courseRebositry.save(course1);

    }
    public Set<Students> studentsList(Integer courseId){
        Course course=courseRebositry.findCourseById(courseId);
        if(course==null){
            throw new ApiException("courses id not found");
        }
        return course.getStudentsSet();
    }

    public void setMajor(Integer studentId,String newMajor){
        Students student= studentRebositry.findStudentsById(studentId);
        if(student==null){
            throw new ApiException("student id not found");
        }
        student.setMajor(newMajor);
        student.getCourseSet().clear();
        studentRebositry.save(student);
    }

}
