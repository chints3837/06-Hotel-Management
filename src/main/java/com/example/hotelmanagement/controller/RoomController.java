package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.entity.Room;
import com.example.hotelmanagement.serviceImpl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/addRoom/{hotelId}")
    public Room addRoom(@RequestBody Room room, @PathVariable Integer hotelId){
        Room roomResult=roomService.saveRoom(room,hotelId);

        return roomResult;
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(){

        List<Room> roomList =roomService.getAllRoom();
        return roomList;
    }

    @DeleteMapping("/deleteById/{deleteId}")
    public void deleteById(@PathVariable Integer deleteId){
        roomService.deleteById(deleteId);
    }

    @GetMapping("/availableRoom")
    public List<Room> getAvailableRoom(){
        return roomService.getAvailableRoom();
    }

    @PutMapping("/bookRoom/{roomId}")
    public boolean isBooked(@PathVariable Integer roomId){

        Boolean result= roomService.bookRoom(roomId);
        return result;
    }

}
