package com.billing.Billingsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseObject <T>{
  private T data;
  private String responseStatus;
  private int responseCode;
}
