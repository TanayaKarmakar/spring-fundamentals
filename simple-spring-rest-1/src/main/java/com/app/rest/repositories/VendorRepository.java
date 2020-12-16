package com.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rest.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
