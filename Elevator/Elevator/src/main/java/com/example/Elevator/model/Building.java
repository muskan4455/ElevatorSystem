package com.example.Elevator.model;

import java.util.ArrayList;

import com.example.Elevator.enums.*;

/**
 * Building
 */
public class Building {

    public ArrayList<Floor>floors=new ArrayList<>();
    public ArrayList<Elevator>elevators=new ArrayList<>();

    public Building(int floorcount,int elevatorcount){

        for(int i=0;i<floorcount;i++){
            Floor floor=new Floor(i+1);
            floors.add(floor);
        }

        for(int i=0;i<elevatorcount;i++){
            Elevator elevator=new Elevator(i+1);
            elevators.add(elevator);
        }
    }

    public ArrayList<Elevator>  callSuitableElevator(Direction direction,Floor floor){
        ArrayList<Elevator> result=new ArrayList<>();
        for(int i=0;i<elevators.size();i++){
            if(direction==Direction.UP && elevators.get(i).currentFloor.floorId<=floor.floorId && elevators.get(i).status==Status.Available){

                 result.add(elevators.get(i));
            }
            else if(direction==Direction.DOWN && elevators.get(i).currentFloor.floorId>=floor.floorId && elevators.get(i).status==Status.Available){
                 result.add(elevators.get(i));
            }
            
        }

        return result;

    }

}