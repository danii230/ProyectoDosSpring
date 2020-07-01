package com.solutions.proyecto.service;

import com.solutions.proyecto.District;
import com.solutions.proyecto.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class DistrictService {
    @Autowired
    private DistrictRepository repository;

    public District findbyId(int id){
        return repository.findById(id).get();
    }

    public List<District> findAll() { return repository.findAll(); }
}
