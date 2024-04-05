package com.billing.Billingsystem.serviceImpl;

import com.billing.Billingsystem.dto.BillFetchDto;
import com.billing.Billingsystem.dto.InvoiceDto;
import com.billing.Billingsystem.models.Invoice;
import com.billing.Billingsystem.models.Items;
import com.billing.Billingsystem.repository.InvoiceRepository;
import com.billing.Billingsystem.service.InvoiceService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@Builder
public class InvoiceServiceImpl implements InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public List<Invoice> getAllInvoices() {
    return invoiceRepository.findAll();
  }

  @Override
  public Invoice createInvoice(InvoiceDto invoice) throws Exception {
    Invoice invoice1 = new Invoice();
    if(invoice == null){
       throw new Exception("Incorrect Data");
    }
    if(CollectionUtils.isEmpty(invoice.getItemLists())){
      throw new Exception("No Bills Found");
    }
    List<Items> itemsList = new LinkedList<>();
    invoice.getItemLists().forEach(bill->{
      Items items = Items.builder().
        itemName(bill.getName())
        .itemPrice(bill.getPrice())
        .totalQty(bill.getQuantity())
        .totalPrice(bill.getRowTotal())
        .build();
      itemsList.add(items);
    });

    invoice1.setCustomerName(invoice.getCustomerName());
    invoice1.setBusinessName(invoice.getBusinessName());
    invoice1.setFinalPrice(invoice.getFinalPrice());
    invoice1.setDate(invoice.getDate());
    invoice1.setItemLists(itemsList);

    return invoiceRepository.save(invoice1);
  }

  @Override
  public List<Invoice> saveAllInvoices(List<InvoiceDto> invoiceList) {
    List<Invoice> invoices = new LinkedList<>();
    return invoiceRepository.saveAll(invoices);
  }

  @Override
  public List<Invoice> getInvoicesByDateRange(LocalDate startDate, LocalDate endDate) {
    return invoiceRepository.findByDateBetween(startDate, endDate);
  }

  @Override
  public List<Invoice> getAllBillsByBusinessName(BillFetchDto billFetchDto) {
    if (billFetchDto == null) {
      // Handle null parameter
      return Collections.emptyList(); // or throw an exception
    }

    List<Invoice> invoice = invoiceRepository.findByBusinessName(billFetchDto.getBusinessName());
    return invoice;
  }


}
