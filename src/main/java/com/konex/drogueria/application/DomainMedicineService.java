package com.konex.drogueria.application;

import com.konex.drogueria.domain.model.Medicine;
import com.konex.drogueria.domain.port.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.lang.System.out;

@Service
@AllArgsConstructor
public class DomainMedicineService implements MedicineService {
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
      Integer valueUnit = this.http.getPrice(medicine.getIdMedicine());
      String name = this.http.getName(medicine.getIdMedicine());
      medicine.setTotalValue(valueUnit*medicine.getAmount());
      medicine.setName(name);
      medicine.setUnitValue(valueUnit);
      medicine.setSaleDate(new Date());
      out.print(medicine);
      Medicine medicineSaved = medicineRepository.save(medicine);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
