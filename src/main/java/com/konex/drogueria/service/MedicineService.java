package com.konex.drogueria.service;

import com.konex.drogueria.entity.Medicine;
import org.springframework.http.ResponseEntity;

public interface MedicineService {
  public ResponseEntity<?> listMedication();
  public ResponseEntity<?> saveMedication(Medicine medicine);
}
