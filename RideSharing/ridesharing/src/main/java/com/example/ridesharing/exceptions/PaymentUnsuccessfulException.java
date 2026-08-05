package com.example.ridesharing.exceptions;

public class PaymentUnsuccessfulException extends RuntimeException{
    public PaymentUnsuccessfulException()
    {
        super("OOPS! , Looks like the payment was unsuccesful, please try again or try with a different payment method");
    }
}
