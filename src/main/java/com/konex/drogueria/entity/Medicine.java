package com.konex.drogueria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
