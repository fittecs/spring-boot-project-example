package com.fittecs.sbpe.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "developer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
  @Id
  @Column(name = "id")
  private Long id;

  private String name;
}
