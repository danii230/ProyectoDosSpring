package com.solutions.proyecto.service;

import com.solutions.proyecto.Canton;
import com.solutions.proyecto.repository.CantonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CantonService {
    @Autowired
    private CantonRepository repository;

    public Canton findbyId(int id){
        return repository.findById(id).get();
    }

    public List<Canton> findAll() { return repository.findAll(); }
}
