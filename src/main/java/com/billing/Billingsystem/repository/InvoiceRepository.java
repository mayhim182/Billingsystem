package com.billing.Billingsystem.repository;

import com.billing.Billingsystem.models.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice,String> {
  public List<Invoice> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
