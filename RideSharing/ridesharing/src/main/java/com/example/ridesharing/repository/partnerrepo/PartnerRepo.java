package com.example.ridesharing.repository.partnerrepo;

import java.util.List;

import com.example.ridesharing.enums.PartnerStatus;
import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.model.Partner;
import com.example.ridesharing.repository.IRepo;

public interface PartnerRepo extends IRepo<String,Partner>{
    List<Partner> getAllPartners();
    List<Partner> getPartnerByStatus(PartnerStatus ps);
    List<Partner> getPartnersByVehicleType(VehicleType vt);
}
