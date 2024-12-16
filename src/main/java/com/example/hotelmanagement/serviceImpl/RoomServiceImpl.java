package com.example.hotelmanagement.serviceImpl;

import com.example.hotelmanagement.entity.Hotel;
import com.example.hotelmanagement.entity.Room;
import com.example.hotelmanagement.repository.HotelRepository;
import com.example.hotelmanagement.repository.RoomRepository;
import com.example.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Room saveRoom(Room room,Integer hotelId) {

        //get hotel temp
        Optional<Hotel> hotelTemp=hotelRepository.findById(hotelId);

        //temp room Obj
        Room roomTemp=new Room();

        roomTemp.setBooked(room.isBooked);
        roomTemp.setrRent(room.getrRent());
        roomTemp.setrType(room.getrType());
        roomTemp.setHotel(hotelTemp.get());









        hotelTemp.get().getRoomsList().add(roomTemp);

        // roomList.add(roomTemp);


        Hotel hotelResult=hotelRepository.save(hotelTemp.get());


        Room result=hotelResult.getRoomsList().get(hotelResult.getRoomsList().size()-1);



        return result;
    }

    public List<Room> getAllRoom(){

        return roomRepository.findAll();
    }

    public void deleteById(Integer id){
        roomRepository.deleteById(id);
    }

    public List<Room> getAvailableRoom(){
        return roomRepository.findByIsBookedFalse();
    }


    public boolean bookRoom(Integer roomId){
       Optional<Room> roomTemp=roomRepository.findById(roomId);

       if(roomTemp.get().isBooked !=true){
           roomTemp.get().setBooked(true);
       }

       Room roomResult=roomRepository.save(roomTemp.get());

       return roomResult.isBooked;

    }
}
