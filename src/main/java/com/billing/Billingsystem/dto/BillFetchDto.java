package com.billing.Billingsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillFetchDto {
  //For fetching bills for current business
  private String businessName;
  private String customerName;
}
