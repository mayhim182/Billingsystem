package com.billing.Billingsystem.service;

import com.billing.Billingsystem.models.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {
  List<Invoice> getAllInvoices();

  Invoice createInvoice(Invoice invoice);

  List<Invoice> getInvoicesByDateRange(LocalDate startDate, LocalDate endDate);
}
