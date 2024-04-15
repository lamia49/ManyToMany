package com.example.school.Rebositry;

import com.example.school.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRebositry extends JpaRepository<Students,Integer> {
    Students findStudentsById(Integer id);
}
