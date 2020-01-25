package com.company.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharityDTO {

  private Long id;

  protected String name;

  private String ein;

  protected String description;
}
