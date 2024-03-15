package com.billing.Billingsystem.models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Items {
  private String itemName;
  private double itemPrice;
  private int totalQty;
  private double totalPrice;
}
