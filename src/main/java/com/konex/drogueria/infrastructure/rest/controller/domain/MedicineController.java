package com.konex.drogueria.infrastructure.rest.controller.domain;

import com.konex.drogueria.domain.model.Medicine;
import com.konex.drogueria.application.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicineController {
  private MedicineService medicineService;

  @GetMapping("/sales")
  public ResponseEntity<List<Medicine>> listMedicines(){
    return (ResponseEntity<List<Medicine>>) medicineService.listMedication();
  }

  @PostMapping("/sales")
  public ResponseEntity<?> saveMedicines(@RequestBody Medicine medicine){
    return medicineService.saveMedication(medicine);
  }

}
