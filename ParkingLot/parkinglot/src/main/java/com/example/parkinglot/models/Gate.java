package com.example.parkinglot.models;

public abstract class Gate {
    protected int id;
    public Gate(int id)
    {
        this.id = id;
    }
    public abstract String getType();
}
