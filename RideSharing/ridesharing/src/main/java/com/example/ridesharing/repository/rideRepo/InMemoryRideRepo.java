package com.example.ridesharing.repository.rideRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.example.ridesharing.enums.RideStatus;
import com.example.ridesharing.model.Ride;

public class InMemoryRideRepo implements RideRepo{
    private final Map<String,Ride> rides;
    
    public InMemoryRideRepo()
    {
        this.rides = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<Ride> getById(String rideId)
    {
        return Optional.ofNullable(rides.get(rideId));
    }

    @Override
    public void save(Ride ride)
    {
        rides.put(ride.getId(), ride);
    }

    @Override
    public void remove(String rideId)
    {
        rides.remove(rideId);
    }

    @Override
    public List<Ride> getAllRides()
    {
        return new ArrayList<>(rides.values());
    }

    @Override
    public List<Ride> getRidesByStatus(RideStatus rs)
    {
        return getAllRides().stream().filter(r->r.getRideStatus()==rs).collect(Collectors.toList());
    }

}
