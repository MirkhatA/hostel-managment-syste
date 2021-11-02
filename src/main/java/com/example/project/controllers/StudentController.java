package com.example.project.controllers;

import com.example.project.dataObject.RoomRepository;
import com.example.project.dataObject.StudentRepository;
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
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoomRepository roomRepository;

    @GetMapping
    public String displayRoom(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "students/viewStudent";
    }

    @GetMapping("/add")
    public String viewStudentForm(Model model) {
        Student aStudent = new Student();
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("student", aStudent);
        model.addAttribute("allRooms", rooms);

        return "students/newStudent";
    }

    @PostMapping("/save")
    public String createStudent(Student student, Model model) {
        studentRepository.save(student);

        return "redirect:/students";
    }

    @GetMapping("/update")
    public String viewUpdateForm(@RequestParam("id") long theId, Model model) {
        Student theStudent = studentRepository.findByStudentId(theId);
        model.addAttribute("student", theStudent);

        return "students/newStudent";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") long theId, Model model) {
        Student theStudent = studentRepository.findByStudentId(theId);
        studentRepository.delete(theStudent);

        return "redirect:/students";
    }
}
