package com.example.school.Service;

import com.example.school.AdressDTO.AdressDTO;
import com.example.school.Api.ApiException;
import com.example.school.Model.Address;
import com.example.school.Model.Course;
import com.example.school.Model.Students;
import com.example.school.Model.Teacher;
import com.example.school.Rebositry.CourseRebositry;
import com.example.school.Rebositry.RebositryTeacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CourseService {
    private  final CourseRebositry courseRebositry;
private final RebositryTeacher rebositryTeacher;
    public void addCourse(Integer teacherID,Course course){
        Teacher teacher= rebositryTeacher.findTeachersById(teacherID);
        if(teacher==null){
            throw new ApiException("id not found");
        }
        course.setTeacher(teacher);
        courseRebositry.save(course);
    }

    public List<Course> getCourse(){
        return courseRebositry.findAll();
    }

    public void updateCourse(Integer id,Course course){
        Course course1=courseRebositry.findCourseById(id);
        if(course1==null){
            throw  new ApiException("id not found");
        }
        course1.setName(course.getName());
        courseRebositry.save(course);
    }

    public void deleteCourse(Integer id){
        Course course=courseRebositry.findCourseById(id);
        if(course==null){
            throw  new ApiException("id not found");
        }
        courseRebositry.delete(course);
    }


    public String getTeacherName(Integer id){
        Course course=courseRebositry.findCourseById(id);
        if(course==null){
            throw  new ApiException("id not found");
        }
        return course.getTeacher().getName();
    }




}
