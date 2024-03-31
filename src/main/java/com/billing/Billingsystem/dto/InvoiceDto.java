package com.billing.Billingsystem.dto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceDto {
  private String id;
  private String businessName;
  private String customerName;
  private List<ItemDto> itemLists;
  private double finalPrice;
  private LocalDate date;
}
