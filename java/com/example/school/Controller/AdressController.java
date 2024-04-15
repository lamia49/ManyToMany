package com.example.school.Controller;

import com.example.school.AdressDTO.AdressDTO;
import com.example.school.Rebositry.RebositryAdress;
import com.example.school.Service.AdressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/school/adress")
@AllArgsConstructor
public class AdressController {
    public final AdressService adressService;


    @PostMapping("/add")
    public ResponseEntity addAdress(@RequestBody @Valid AdressDTO adressDTO){
        adressService.addAdress(adressDTO);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity getAdress(){
        return ResponseEntity.status(200).body(adressService.getAdress());
    }


    @PutMapping("/update")
    public ResponseEntity updateAdress(@RequestBody @Valid AdressDTO adressDTO){
        adressService.updateAdress(adressDTO);
        return ResponseEntity.status(200).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdress(@PathVariable Integer id){
        adressService.deleteAdress(id);
        return ResponseEntity.status(200).body("deleted");
    }
}
