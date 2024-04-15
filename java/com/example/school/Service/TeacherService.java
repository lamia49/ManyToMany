package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Teacher;
import com.example.school.Rebositry.RebositryTeacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final RebositryTeacher rebositryTeacher;


    public List getTeacher(){
        return rebositryTeacher.findAll();
    }

    public void addTeacher(Teacher teacher){
        rebositryTeacher.save(teacher);
    }

    public void  updateTeacher(Integer id ,Teacher teacher){

        Teacher teacher1= rebositryTeacher.findTeachersById(id);
        if(teacher1==null){
            throw new ApiException("id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        rebositryTeacher.save(teacher1);
    }


    public void  delete(Integer id){
        Teacher teacher= rebositryTeacher.findTeachersById(id);
        if(teacher==null){
            throw new ApiException("id not found");
        }
        rebositryTeacher.delete(teacher);
    }


    public Teacher getTeacherDetails(Integer id){

        Teacher teacher= rebositryTeacher.findTeachersById(id);
        if(teacher==null){
            throw new ApiException("id not found");
        }
        return teacher;

    }

}
