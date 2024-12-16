package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.serviceImpl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        Hotel hotelResult= hotelService.saveHotel(hotel);

        return hotelResult;
    }

    @GetMapping("/getHotelById/{hotelId}")
    public Hotel getHotelById(@PathVariable Integer hotelId){
        Hotel hotelResult=hotelService.getHotelById(hotelId);
        return hotelResult;
    }

}
