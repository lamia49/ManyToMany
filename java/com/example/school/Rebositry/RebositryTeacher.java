package com.example.school.Rebositry;

import com.example.school.Model.Address;
import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebositryTeacher extends JpaRepository<Teacher,Integer> {
    Teacher findTeachersById(Integer id);

}
