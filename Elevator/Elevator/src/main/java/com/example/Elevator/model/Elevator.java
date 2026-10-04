package com.example.Elevator.model;

import com.example.Elevator.enums.*;
/**
 * Elevator
 */
public class Elevator {

    public Direction dir;
    public Status status;
    public Integer elevatorId;
    public Floor currentFloor;
    public Elevator(Integer id){
        this.dir=Direction.UP;
        this.status=Status.Available;
        this.elevatorId=id;
        this.currentFloor=new Floor(1);
    }
}