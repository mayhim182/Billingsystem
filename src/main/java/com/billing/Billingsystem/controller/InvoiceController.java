package com.billing.Billingsystem.controller;

import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.repository.InvoiceRepository;
import com.billing.Billingsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
  @Autowired
  private InvoiceRepository invoiceRepository;

  @Autowired
  private InvoiceService invoiceService;

  @GetMapping
  public List<Invoice> getAllInvoices(){
    return invoiceService.getAllInvoices();
  }

  @PostMapping
  public Invoice createInvoice(@RequestBody Invoice invoice){
    return invoiceService.createInvoice(invoice);
  }

}
