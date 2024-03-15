package com.billing.Billingsystem.serviceImpl;

import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.repository.InvoiceRepository;
import com.billing.Billingsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public List<Invoice> getAllInvoices() {
    return invoiceRepository.findAll();
  }

  @Override
  public Invoice createInvoice(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  @Override
  public List<Invoice> getInvoicesByDateRange(LocalDate startDate, LocalDate endDate) {
    return invoiceRepository.findByDateBetween(startDate, endDate);
  }
}
