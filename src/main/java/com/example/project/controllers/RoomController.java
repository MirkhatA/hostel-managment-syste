package com.example.project.controllers;

import com.example.project.dataObject.HostelRepository;
import com.example.project.dataObject.RoomRepository;
import com.example.project.entities.Hostel;
import com.example.project.entities.Room;
import com.example.project.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HostelRepository hostelRepository;

    @GetMapping
    public String displayRoom(Model model) {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);

        return "rooms/viewRooms";
    }



    @GetMapping("/add")
    public String viewRoomForm(Model model) {
        Room aRoom = new Room();
        List<Hostel> hostels = hostelRepository.findAll();
        model.addAttribute("room", aRoom);
        model.addAttribute("allHostels", hostels);

        return "rooms/newRoom";
    }

    @PostMapping("/save")
    public String createRoom(Model model, Room room) {
        roomRepository.save(room);

        return "redirect:/rooms/add";
    }


}
