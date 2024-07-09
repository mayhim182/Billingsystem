package com.billing.Billingsystem.controller;

import com.billing.Billingsystem.dto.BillFetchDto;
import com.billing.Billingsystem.dto.DateRange;
import com.billing.Billingsystem.dto.InvoiceDto;
import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {
  @Autowired
  private InvoiceService invoiceService;

  @GetMapping
  public List<Invoice> getAllInvoices(){
    return invoiceService.getAllInvoices();
  }

  @PostMapping("/saveInvoice")
  public Invoice createInvoice(@RequestBody InvoiceDto invoice) throws Exception {
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

  @PostMapping("/getByBusiness")
  @Cacheable(value = "getAllBillsByBusinessName", key = "#a0")
  public List<Invoice> getInvoicesByBusiness(@RequestBody BillFetchDto billFetchDto){
    return invoiceService.getAllBillsByBusinessName(billFetchDto);
  }


}
