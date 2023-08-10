package com.konex.drogueria.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "sales")
public class Medicine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer idMedicine;
  private Date saleDate;
  private String name;
  private Integer amount;
  private Integer unitValue;
  private Integer totalValue;
}
