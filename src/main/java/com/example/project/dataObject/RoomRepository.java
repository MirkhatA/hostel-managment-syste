package com.example.project.dataObject;

import com.example.project.entities.Hostel;
import com.example.project.entities.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    @Override
    public List<Room> findAll();
}
