package com.proyectoapi.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String lastname;
  @Column(length = 10)
  private String cellphone;
  @Column(nullable = false)
  private String address;
}
