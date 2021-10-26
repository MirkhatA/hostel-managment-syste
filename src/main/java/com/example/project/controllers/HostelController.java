package com.example.project.controllers;

import com.example.project.dataObject.HostelRepository;
import com.example.project.entities.Hostel;
import com.example.project.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hostels")
public class HostelController {

    @Autowired
    HostelRepository hostelRepository;

    @GetMapping
    public String displayRoom(Model model) {
        List<Hostel> hostels = hostelRepository.findAll();
        model.addAttribute("hostels", hostels);

        return "hostels/viewHostel";
    }

    @GetMapping("/add")
    public String viewHostelForm(Model model) {
        Hostel aHostel = new Hostel();

        model.addAttribute("hostel", aHostel);

        return "hostels/newHostel";
    }

    @PostMapping("/save")
    public String createHostel(Hostel hostel, Model model) {
        hostelRepository.save(hostel);

        return "redirect:/hostels/add";
    }
}
