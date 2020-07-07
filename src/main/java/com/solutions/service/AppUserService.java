package com.solutions.service;
import com.solutions.proyecto.AppUser;
import com.solutions.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppUserService {
    @Autowired
    private AppUserRepository repository;

    public AppUser findbyId(int id){
        return repository.findById(id).get();
    }

    public List<AppUser> findAll() { return repository.findAll(); }
}
