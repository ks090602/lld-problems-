package com.example.ridesharing.exceptions;

public class PartnerNotFoundException extends RuntimeException{
    public PartnerNotFoundException(String partnerId)
    {
        super("No Such Partner found with id: " + partnerId);
    }
}
