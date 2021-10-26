package com.example.project.controllers;

import com.example.project.dataObject.HostelRepository;
import com.example.project.entities.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HostelRepository hostelRepository;

    @GetMapping("/")
    public String findAll(Model model) {
        List<Hostel> hostels =hostelRepository.findAll();
        model.addAttribute("hostelList", hostels);

        return "main/home";
    }

}
