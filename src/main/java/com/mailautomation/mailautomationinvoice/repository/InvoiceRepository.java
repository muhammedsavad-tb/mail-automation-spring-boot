package com.mailautomation.mailautomationinvoice.repository;

import com.mailautomation.mailautomationinvoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByVendorVendorId(Long vendorId);

//newwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    //newwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Query("SELECT SUM(i.tdsAmount) FROM Invoice i " +
            "WHERE i.vendor.id = :vendorId " +
            "AND FUNCTION('MONTH', i.invoiceDate) = :month " +
            "AND FUNCTION('YEAR', i.invoiceDate) = :year ")
    Double getTotalTdsForVendorsByMonth(@Param("vendorId") Long vendorId,
                                        @Param("month") int month,
                                        @Param("year") int year);
}
//newwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww