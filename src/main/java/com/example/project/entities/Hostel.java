package com.example.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hostelId;

    private String name;
    private int noOfRooms;
    private int noOfStudents;
    private double roomPrice;

    public Hostel() {

    }

    public Hostel(String name, int noOfRooms, int noOfStudents, double roomPrice) {
        this.name = name;
        this.noOfRooms = noOfRooms;
        this.noOfStudents = noOfStudents;
        this.roomPrice = roomPrice;
    }

    public long getHostelId() {
        return hostelId;
    }

    public void setHostelId(long hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }


}
