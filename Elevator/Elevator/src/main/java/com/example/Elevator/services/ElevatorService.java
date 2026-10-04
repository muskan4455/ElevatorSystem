package com.example.Elevator.services;

import com.example.Elevator.model.*;

import java.util.ArrayList;

import com.example.Elevator.enums.*;
/**
 * ElevatorService
 */

public class ElevatorService {

    Building building;

    public ElevatorService(int floorCount,int elevatorCount){
        this.building=new Building(floorCount,elevatorCount);
    }
   public ArrayList<Elevator> requestElevator(Direction direction, Floor currfloor){
         return building.callSuitableElevator(direction,currfloor);
    }

   public StringBuilder addDestination(Floor floor,int elevatorId){
        building.elevators.get(elevatorId-1).currentFloor=floor;
        building.elevators.get(elevatorId-1).status=Status.Full;
        StringBuilder result = new StringBuilder("");

        result.append("Elevator is occupied till the destination which is Floor: ");
        result.append(floor.floorId);

        return result;
    }
     public String releaseElevator(int elevatorId){
        
        building.elevators.get(elevatorId-1).status=Status.Available;
        return "Elevator Successfully Released";
    }
    
}