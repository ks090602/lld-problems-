package com.example.ridesharing.service;

import java.util.List;
import com.example.ridesharing.enums.PartnerStatus;
import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.exceptions.PartnerNotFoundException;
import com.example.ridesharing.model.Partner;
import com.example.ridesharing.repository.partnerrepo.PartnerRepo;

public class PartnerService {
    private final PartnerRepo partnerRepo;

    public PartnerService(PartnerRepo partnerRepo) {
        this.partnerRepo = partnerRepo;
    }

    public Partner getPartnerById(String partnerId) {
        return partnerRepo.getById(partnerId).orElseThrow(()->new PartnerNotFoundException(partnerId));
    }

    public void savePartner(Partner partner) {
        partnerRepo.save(partner);
    }

    public void removePartner(String partnerId) {
        partnerRepo.remove(partnerId);
    }

    public List<Partner> getAllPartners() {
        return partnerRepo.getAllPartners();
    }

    public List<Partner> getPartnersByStatus(PartnerStatus ps) {
        return partnerRepo.getPartnerByStatus(ps);
    }

    public List<Partner> getPartnersByVehicleType(VehicleType vt) {
        return partnerRepo.getPartnersByVehicleType(vt);
    }
}