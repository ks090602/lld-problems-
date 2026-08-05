package com.example.ridesharing.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.ridesharing.dto.RideRequest;
import com.example.ridesharing.enums.DriverAssignmentStrategyType;
import com.example.ridesharing.enums.PartnerStatus;
import com.example.ridesharing.enums.PaymentType;
import com.example.ridesharing.enums.PricingStrategyType;
import com.example.ridesharing.enums.VehicleType;
import com.example.ridesharing.exceptions.DriverUnavailableException;
import com.example.ridesharing.exceptions.PaymentUnsuccessfulException;
import com.example.ridesharing.model.Address;
import com.example.ridesharing.model.Partner;
import com.example.ridesharing.model.Ride;
import com.example.ridesharing.model.User;
import com.example.ridesharing.model.Vehicle;


public class RideBookingService {
    private final UserService userService;
    private final RideService rideService;
    private final PartnerService partnerService;
    private final PricingService pricingService;
    private final PaymentProcessor paymentService;
    private final DriverAssignmentService getDriverService;
    private final NotificationService notificationService;

    public RideBookingService(UserService userService, RideService rideService, PartnerService partnerService,
            PricingService pricingService, PaymentProcessor paymentService, DriverAssignmentService getDriverService,
            NotificationService notificationService) {
        this.userService = userService;
        this.rideService = rideService;
        this.partnerService = partnerService;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.getDriverService = getDriverService;
        this.notificationService = notificationService;
    }

    public Map<VehicleType,Double> getFareForAllVehiclesTypes(PricingStrategyType pricingStrategyType,Address pickup,Address drop)
    {
        List<Vehicle> allAvailableVehicles = partnerService.getPartnersByStatus(PartnerStatus.AVAILABLE).stream().map(p->p.getVehicle()).collect(Collectors.toList());
        return pricingService.getPrice(pricingStrategyType, pickup, drop, allAvailableVehicles);
    }

    public synchronized Ride bookRide(RideRequest rideRequest)
    {

// For your target companies, know all three levels:

// Basic: synchronized method (correct but limited).
// Good: Explain why it's not scalable -> I'm using this as a simple correctness mechanism for the MVP. It doesn't scale because unrelated bookings block each other. In production I'd replace this with per-partner locking
// Excellent: Describe a PartnerLockProvider with ConcurrentHashMap<String, ReentrantLock> and how tryLock()/unlock() would work. (Refer the code in BookMyShow seat booking logic)



        // getting partner by delegating the task to DriverAssignmentService
        Partner p = getDriverService.getPartner(rideRequest, partnerService.getPartnersByStatus(PartnerStatus.AVAILABLE), DriverAssignmentStrategyType.NEAREST);

        if(p==null)
        {
            throw new DriverUnavailableException();
        }

        // once a partner accepts a ride request we can create a ride
        Ride newRide = new Ride(UUID.randomUUID().toString(), rideRequest.getUser(), p, rideRequest.getFare(), rideRequest.getPickUp(), rideRequest.getDrop());
        
        // persistence 
        rideService.saveRide(newRide);

        // changing partner status 
        p.setPartnerStatusOnRide();
        
        // changing ride status 
        newRide.setRideStatusInProgress();

        // updating user ride history 
        rideRequest.getUser().addRide(newRide);

        // notification
        notificationService.notify(newRide);
        return newRide;
    } 

    public void cancelRide(Ride ride)
    {
        // set ride status as cancelled 
        ride.setRideStatusCancelled();

        // change partner status 
        partnerService.getPartnerById(ride.getPartner().getId()).setPartnerStatusAvailable();
    }

    public void completeRide(Ride ride,PaymentType paymentType)
    {
        // pay the amount , delegating the task to payment service
        if(paymentService.pay(paymentType, ride))
        {
            // payment is successful so ride is actually completed now 

            // changing ride Status 
            ride.setRideStatusCompleted();
            
            // changing the partner Status 
            partnerService.getPartnerById(ride.getPartner().getId()).setPartnerStatusAvailable();
        }
        else 
        {
            throw new PaymentUnsuccessfulException();
        }
    }

    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
