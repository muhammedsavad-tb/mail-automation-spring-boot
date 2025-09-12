package com.mailautomation.mailautomationinvoice.dto;

import java.time.LocalDate;

public class InvoiceRequest {

    private String vendorName;
    private String vendorPan;
    private String mailId;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private Double invoiceAmount;
    private Double taxableValue;
    private Double totalGst;
    private String paymentType;
    private String natureOfTransaction;
    private Double tdsRate;
    private Double tdsAmount;
    private String attachmentLink;

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

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getTaxableValue() {
        return taxableValue;
    }

    public void setTaxableValue(Double taxableValue) {
        this.taxableValue = taxableValue;
    }

    public Double getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(Double totalGst) {
        this.totalGst = totalGst;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNatureOfTransaction() {
        return natureOfTransaction;
    }

    public void setNatureOfTransaction(String natureOfTransaction) {
        this.natureOfTransaction = natureOfTransaction;
    }

    public Double getTdsRate() {
        return tdsRate;
    }

    public void setTdsRate(Double tdsRate) {
        this.tdsRate = tdsRate;
    }

    public Double getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(Double tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public String getAttachmentLink() {
        return attachmentLink;
    }

    public void setAttachmentLink(String attachmentLink) {
        this.attachmentLink = attachmentLink;
    }
}
