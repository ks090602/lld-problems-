package com.example.ridesharing.service;

import java.util.List;
import com.example.ridesharing.enums.RideStatus;
import com.example.ridesharing.exceptions.RideNotFoundException;
import com.example.ridesharing.model.Ride;
import com.example.ridesharing.repository.rideRepo.RideRepo;

public class RideService {
    private final RideRepo rideRepo;

    public RideService(RideRepo rideRepo) {
        this.rideRepo = rideRepo;
    }

    public Ride getRideById(String rideId) {
        return rideRepo.getById(rideId).orElseThrow(()->new RideNotFoundException(rideId));
    }

    public void saveRide(Ride ride) {
        rideRepo.save(ride);
    }

    public void removeRide(String rideId) {
        rideRepo.remove(rideId);
    }

    public List<Ride> getAllRides() {
        return rideRepo.getAllRides();
    }

    public List<Ride> getRidesByStatus(RideStatus rs) {
        return rideRepo.getRidesByStatus(rs);
    }
}