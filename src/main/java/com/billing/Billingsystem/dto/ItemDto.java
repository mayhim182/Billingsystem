package com.billing.Billingsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
  private String name;
  private double itemPrice;
  private int quantity;
  private double rowTotal;
}
