package com.billing.Billingsystem.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DateRange {
  private LocalDate startDate;
  private LocalDate endDate;
}
