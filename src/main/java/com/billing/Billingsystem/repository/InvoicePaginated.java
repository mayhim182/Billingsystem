package com.billing.Billingsystem.repository;

import com.billing.Billingsystem.models.Invoice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;


//Point to be noted here is that extending JpaRepository would have been same as it extends PagingAndSortingRepo
public interface InvoicePaginated extends PagingAndSortingRepository<Invoice, String> {
  List<Invoice> findByBusinessName(String businessName, Pageable pageable);
}
