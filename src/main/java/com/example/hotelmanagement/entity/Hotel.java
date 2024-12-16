package com.example.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer hId;

    public String hName;

    public String hCity;

    public float hRating;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = false)
    public List<Room> roomsList=new ArrayList<>();

    public Hotel(){

    }

    public Hotel(Integer hId, String hName, String hCity, float hRating, List<Room> roomsList) {
        this.hId = hId;
        this.hName = hName;
        this.hCity = hCity;
        this.hRating = hRating;
        this.roomsList = roomsList;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethCity() {
        return hCity;
    }

    public void sethCity(String hCity) {
        this.hCity = hCity;
    }

    public float gethRating() {
        return hRating;
    }

    public void sethRating(float hRating) {
        this.hRating = hRating;
    }

    public List<Room> getRoomsList() {
        if(this.roomsList ==null){
            return this.roomsList=new ArrayList<>();
        }
        return roomsList;
    }

    public void setRoomsList(List<Room> roomsList) {
        this.roomsList = roomsList;
    }
}
