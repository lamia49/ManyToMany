package com.example.school.AdressDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdressDTO {
    private Integer teacherId;
    @NotNull(message = "area must be not empty ")
    private String area;
    @NotNull(message = "street must be not empty ")
    private String street;
    @NotNull(message = "build number must be not empty")
    private Integer buildingNumber;
}
