package com.example.school.Service;

import com.example.school.AdressDTO.AdressDTO;
import com.example.school.Api.ApiException;
import com.example.school.Model.Address;
import com.example.school.Model.Teacher;
import com.example.school.Rebositry.RebositryAdress;
import com.example.school.Rebositry.RebositryTeacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdressService {
    private final RebositryAdress rebositryAdress;
private  final RebositryTeacher rebositryTeacher;


public void addAdress(AdressDTO adressDTO){
    Teacher teacher=rebositryTeacher.findTeachersById(adressDTO.getTeacherId());
    if(teacher==null){
        throw  new ApiException("id not found");
    }

    Address address=new Address(null,adressDTO.getArea(), adressDTO.getStreet(), adressDTO.getBuildingNumber(),teacher);
    rebositryAdress.save(address);
}

public List<Address>getAdress(){
    return rebositryAdress.findAll();
}

public void updateAdress(AdressDTO adressDTO){
    Address address=rebositryAdress.findAddressById(adressDTO.getTeacherId());
    if(address==null){
        throw  new ApiException("id not found");
    }

    address.setArea(adressDTO.getArea());
    address.setStreet(adressDTO.getStreet());
    address.setBuildingNumber(adressDTO.getBuildingNumber());
    rebositryAdress.save(address);
}

public void deleteAdress(Integer id){
    Address address=rebositryAdress.findAddressById(id);
    if(address==null){
        throw  new ApiException("id not found");
    }
    rebositryAdress.delete(address);
}

}
