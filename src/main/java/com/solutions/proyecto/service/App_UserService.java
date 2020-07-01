package com.solutions.proyecto.service;
import com.solutions.proyecto.App_User;
import com.solutions.proyecto.repository.App_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class App_UserService {
    @Autowired
    private App_UserRepository repository;

    public App_User findbyId(int id){
        return repository.findById(id).get();
    }

    public List<App_User> findAll() { return repository.findAll(); }
}
