package com.mailautomation.mailautomationinvoice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //auto generate IDs (1,2,3...) for each vendor
    private Long vendorId;

    private String vendorName;
    private String vendorPan;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vendor")
    //one vendor >> many invoices, linked via "vendor" field in Invoice
    private List<Invoice> invoices;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPan() {
        return vendorPan;
    }

    public void setVendorPan(String vendorPan) {
        this.vendorPan = vendorPan;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
