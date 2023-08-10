package com.konex.drogueria.application;

import com.konex.drogueria.domain.model.Medicine;
import org.springframework.http.ResponseEntity;

public interface MedicineService {
  public ResponseEntity<?> listMedication();
  public ResponseEntity<?> saveMedication(Medicine medicine);
}
