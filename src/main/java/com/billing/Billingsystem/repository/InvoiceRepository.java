package com.billing.Billingsystem.repository;

import com.billing.Billingsystem.models.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice,String> {
  public List<Invoice> findByDateBetween(LocalDate startDate, LocalDate endDate);

  public List<Invoice> findByBusinessName(String businessName);
}
