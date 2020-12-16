package com.app.rest.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.rest.api.v1.model.VendorDTO;
import com.app.rest.domain.Vendor;

@Mapper
public interface VendorMapper {
	VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
	
	VendorDTO vendorToVendorDTO(Vendor vendor);
    
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
