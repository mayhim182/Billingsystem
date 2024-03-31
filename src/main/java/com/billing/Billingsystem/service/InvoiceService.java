package com.billing.Billingsystem.service;

import com.billing.Billingsystem.dto.BillFetchDto;
import com.billing.Billingsystem.dto.InvoiceDto;
import com.billing.Billingsystem.models.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {
  List<Invoice> getAllInvoices();

  Invoice createInvoice(InvoiceDto invoice) throws Exception;

  List<Invoice> saveAllInvoices(List<InvoiceDto> invoiceList);

  List<Invoice> getInvoicesByDateRange(LocalDate startDate, LocalDate endDate);

  List<Invoice> getAllBillsByBusinessName(BillFetchDto billFetchDto);
}
