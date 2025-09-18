package com.mailautomation.mailautomationinvoice.controller;

import com.mailautomation.mailautomationinvoice.model.Invoice;
import com.mailautomation.mailautomationinvoice.model.Vendor;
import com.mailautomation.mailautomationinvoice.repository.InvoiceRepository;
import com.mailautomation.mailautomationinvoice.repository.VendorRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "https://muhammedsavad-tb-mailautomationfrontend-react.buv7hx.easypanel.host")
//@CrossOrigin(origins = "https://134.209.155.202")
//@CrossOrigin(origins = "http://localhost:5173")
public class VendorController {

    private final VendorRepository vendorRepo;
    private final InvoiceRepository invoiceRepo;

    public VendorController(VendorRepository vendorRepo, InvoiceRepository invoiceRepo){
        this.vendorRepo = vendorRepo;
        this.invoiceRepo = invoiceRepo;
    }

    //create a new vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor){
        return vendorRepo.save(vendor);
    }

    //get all vendors
    @GetMapping
    public List<Vendor> getAllVendors(){
        return vendorRepo.findAll();

    }

    //get invoices for a specific vendor
    @GetMapping("/{vendorId}/invoices")
    public List<Invoice> getInvoicesByVendor(@PathVariable Long vendorId){
        return invoiceRepo.findByVendorVendorId(vendorId);
    }

}
