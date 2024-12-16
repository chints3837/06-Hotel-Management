package com.example.hotelmanagement.serviceImpl;

import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.repository.HotelRepository;
import com.example.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel saveHotel(Hotel hotel) {
        Hotel hotelResult= hotelRepository.save(hotel);

        return hotelResult;
    }


    public Hotel getHotelById(Integer hotelId){
        Optional<Hotel> hotelResult=hotelRepository.findById(hotelId);
        return hotelResult.get();
    }
}
