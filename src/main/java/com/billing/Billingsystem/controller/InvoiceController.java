package com.billing.Billingsystem.controller;

import com.billing.Billingsystem.dto.DateRange;
import com.billing.Billingsystem.dto.InvoiceDto;
import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.repository.InvoiceRepository;
import com.billing.Billingsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
  @Autowired
  private InvoiceRepository invoiceRepository;

  @Autowired
  private InvoiceService invoiceService;

  @GetMapping
  public List<Invoice> getAllInvoices(){
    return invoiceService.getAllInvoices();
  }

  @PostMapping("/saveInvoice")
  public Invoice createInvoice(@RequestBody Invoice invoice){
    return invoiceService.createInvoice(invoice);
  }

  @PostMapping("/saveAllInvoices")
  public List<Invoice> saveAllInvoices(@RequestBody List<InvoiceDto> invoiceList){
    return invoiceService.saveAllInvoices(invoiceList);
  }

  @PostMapping("/getBetweenDates")
  public List<Invoice> getInvoicesBetweenStartDateAndEndDate(@RequestBody DateRange dateRange){
    return invoiceService.getInvoicesByDateRange(dateRange.getStartDate(),dateRange.getEndDate());
  }


}
