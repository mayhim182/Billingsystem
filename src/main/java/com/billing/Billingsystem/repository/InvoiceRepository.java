package com.billing.Billingsystem.repository;

import com.billing.Billingsystem.models.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice,String> {

}
