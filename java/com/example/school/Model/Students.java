package com.example.school.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@NotEmpty(message = "name must be not empty")
    private String name;
@NotEmpty(message = "major must be not null")
    private String major;
    @NotNull(message = "age must be not null")
    private Integer age;
    @ManyToMany
    private Set<Course>courseSet;
}
