package com.mailautomation.mailautomationinvoice.controller;

import com.mailautomation.mailautomationinvoice.model.Invoice;
import com.mailautomation.mailautomationinvoice.model.Vendor;
import com.mailautomation.mailautomationinvoice.dto.InvoiceRequest;
import com.mailautomation.mailautomationinvoice.repository.InvoiceRepository;
import com.mailautomation.mailautomationinvoice.repository.VendorRepository;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import org.springframework.http.RequestEntity;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = {"https://134.209.155.202", "http://localhost:5173" })
//@CrossOrigin(origins = "https://muhammedsavad-tb-mailautomationfrontend-react.buv7hx.easypanel.host")
//@CrossOrigin(origins = "https://134.209.155.202")
//@CrossOrigin(origins = "http://localhost:5173")
public class InvoiceController {

    private final VendorRepository vendorRepo;
    private final InvoiceRepository invoiceRepo;

    public InvoiceController(VendorRepository vendorRepo, InvoiceRepository invoiceRepo){
        this.vendorRepo = vendorRepo;
        this.invoiceRepo = invoiceRepo;

    }

    //create a new invoice under a vendor
    @PostMapping
    public ResponseEntity<Invoice>createInvoice(@RequestBody InvoiceRequest request){
        //find or create vendor
        Vendor vendor = vendorRepo.findByVendorName(request.getVendorName())
                .orElseGet(() -> {
                    Vendor newVendor = new Vendor();
                    newVendor.setVendorName(request.getVendorName());
                    newVendor.setVendorPan(request.getVendorPan());
                    return vendorRepo.save(newVendor);
                });

        //create invoice and link vendor
        Invoice invoice = new Invoice();
        invoice.setVendor(vendor);
        invoice.setInvoiceNumber(request.getInvoiceNumber());
        invoice.setInvoiceDate(request.getInvoiceDate() != null ? request.getInvoiceDate() : LocalDate.now());
        invoice.setInvoiceAmount(request.getInvoiceAmount());
        invoice.setTaxableValue(request.getTaxableValue());
        invoice.setTotalGst(request.getTotalGst());
        invoice.setPaymentType(request.getPaymentType());
        invoice.setNatureOfTransaction(request.getNatureOfTransaction());
        invoice.setTdsRate(request.getTdsRate());
        invoice.setTdsAmount(request.getTdsAmount());
        invoice.setAttachmentLink(request.getAttachmentLink());
        invoice.setMailId(request.getMailId());

        //save invoices
        Invoice saveInvoice = invoiceRepo.save(invoice);
        return ResponseEntity.ok(saveInvoice);

    }

    //get all invoices
    @GetMapping
    public List<Invoice> getAllInvoices(){
        return invoiceRepo.findAll();
    }

    //get invoices by vendor id
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Invoice>> getInvoiceByVendor(@PathVariable Long vendorId){
        List<Invoice> invoices = invoiceRepo.findByVendorVendorId(vendorId);
        return ResponseEntity.ok(invoices);
    }

    // delete all vendors
    @DeleteMapping("/all-vendors")
    public void deleteAllVendors(){
        vendorRepo.deleteAll();
    }

    //delete all invoices
    @DeleteMapping("/all-invoices")
    public void deleteAllInvoices(){
        invoiceRepo.deleteAll();
    }





}
