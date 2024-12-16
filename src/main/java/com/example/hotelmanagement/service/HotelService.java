package com.example.hotelmanagement.service;

import com.example.hotelmanagement.entity.Hotel;
import org.springframework.stereotype.Service;

@Service
public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotelById(Integer hotelId);
}
