package com.example.ridesharing.repository.partnerrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.ridesharing.enums.PartnerStatus;
import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.model.Partner;

public class InMemoryPartnerRepo implements PartnerRepo{
    private final Map<String, Partner> partners;

    public InMemoryPartnerRepo(){
        partners = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Partner> getById(String partnerId)
    {
        return Optional.ofNullable(partners.get(partnerId));
    }

    @Override
    public void save(Partner p)
    {
        partners.put(p.getId(), p);
    }

    @Override
    public void remove(String partnerId)
    {
        partners.remove(partnerId);
    } 

    @Override
    public List<Partner> getAllPartners()
    {
        return new ArrayList<>(partners.values());
    }

    @Override
    public List<Partner> getPartnerByStatus(PartnerStatus ps)
    {
        return getAllPartners().stream().filter(p->p.getPartnerStatus()==ps).collect(Collectors.toList());
    }

    @Override
    public List<Partner> getPartnersByVehicleType(VehicleType vt)
    {
        return getAllPartners().stream().filter(p->p.getVehicle().getVehicleType()==vt).collect(Collectors.toList());
    }
}
