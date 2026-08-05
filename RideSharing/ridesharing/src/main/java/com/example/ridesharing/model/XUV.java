package com.example.ridesharing.model;

import com.example.ridesharing.enums.VehicleType;

public class XUV extends Vehicle{
    public XUV(String vehicleNumber)
    {
        super(vehicleNumber, VehicleType.XUV, 45);
    }
}
