package com.example.school.Rebositry;

import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRebositry extends JpaRepository<Course,Integer> {
//    Course findCoursesById(Integer id);
    Course findCourseById(Integer id);
    Course findCoursesByTeacher(Teacher teacher);
}
