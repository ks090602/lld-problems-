package com.example.ridesharing.repository.rideRepo;

import java.util.List;

import com.example.ridesharing.enums.RideStatus;
import com.example.ridesharing.model.Ride;
import com.example.ridesharing.repository.IRepo;

public interface RideRepo extends IRepo<String,Ride>{
    List<Ride> getAllRides();
    List<Ride> getRidesByStatus(RideStatus rs);
}
