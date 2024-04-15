package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "age must be not empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email(message = "set vailed email")
    @NotEmpty(message = "email must be not empty")
    @Column(columnDefinition = "varchar(30) unique")
    private String email;
    @NotEmpty(message = "salary must be not empty")
    @Column(columnDefinition = "int not null")
    private String salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
//    @JsonIgnore
    private Set<Course>courses;
}
