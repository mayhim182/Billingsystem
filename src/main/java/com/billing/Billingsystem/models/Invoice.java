package com.billing.Billingsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Invoice {
  @Id
  private String id;
  @NotBlank
  private String businessName;
  @NotBlank
  private String customerName;
  private List<Items> itemLists;
  private double finalPrice;
  private LocalDate date;
  private String username;
}
