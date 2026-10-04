package com.example.Elevator.controller;

import com.example.Elevator.services.ElevatorService;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.example.Elevator.model.*;
import com.example.Elevator.enums.*;;

/**
 * Controller
 */
@RestController
@RequestMapping("/Elevator")
public class Controller {

    public ElevatorService service;

    public Controller(){

        this.service=new ElevatorService(10,5);

    }
     @GetMapping("/RequestElevator")
    public ArrayList<Elevator> requestElevator(
            @RequestParam("direction") Direction direction,
            @RequestParam("currFloor") int currFloor) {

        Floor floor = new Floor(currFloor);

        return service.requestElevator(direction, floor);
    }
    @GetMapping("/addDestination")
    public StringBuilder addDestination(@RequestParam("floorId")int floorId, @RequestParam("elevatorId")int elevator){
        Floor floor=new Floor(floorId);
        return  service.addDestination(floor,elevator);
    }

    @GetMapping("/releaseElevator")
    public String releaseElevator(@RequestParam("elevatorId")int elevatorId){
        
        return  service.releaseElevator(elevatorId);
    }
}