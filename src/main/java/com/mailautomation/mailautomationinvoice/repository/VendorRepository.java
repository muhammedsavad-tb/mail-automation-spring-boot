package com.mailautomation.mailautomationinvoice.repository;

import com.mailautomation.mailautomationinvoice.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByVendorName(String vendorName);

}
