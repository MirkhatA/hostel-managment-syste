package com.example.project.dataObject;

import com.example.project.entities.Hostel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HostelRepository extends CrudRepository<Hostel, Long> {

    @Override
    public List<Hostel> findAll();
}
