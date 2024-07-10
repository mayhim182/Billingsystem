package com.billing.Billingsystem.controller;

import com.billing.Billingsystem.dto.BillFetchDto;
import com.billing.Billingsystem.dto.DateRange;
import com.billing.Billingsystem.dto.InvoiceDto;
import com.billing.Billingsystem.dto.ResponseObject;
import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


  @PostMapping("/getInvoicesForusername")
  public ResponseEntity<ResponseObject<List<Invoice>>>  invoicesForUserName() throws Exception{
    List<Invoice> invoiceList = null;
    ResponseObject<List<Invoice>> responseObject = new ResponseObject<>();
    try{
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String userName = authentication.getName();
      invoiceList = invoiceService.getInvoicesByUsername(userName);
      responseObject.setData(invoiceList);
      responseObject.setResponseCode(200);
      responseObject.setResponseStatus("OK");
    } catch (Exception e) {
      //Handle Exception here
    }
    return ResponseEntity.ok(responseObject);
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
