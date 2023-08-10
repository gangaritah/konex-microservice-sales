package com.konex.drogueria.service;

import com.konex.drogueria.entity.Medicine;
import com.konex.drogueria.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.konex.drogueria.service.Http;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService{
  private Http http;
  private MedicineRepository medicineRepository;
  @Override
  public ResponseEntity<?> listMedication() {
    List<Medicine> medicines;
    try{
      medicines = medicineRepository.findAll();
      return new ResponseEntity<>(medicines, HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> saveMedication(Medicine medicine) {
    try{
      out.print(medicine);
      Medicine medicineSaved = medicineRepository.save(medicine);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
