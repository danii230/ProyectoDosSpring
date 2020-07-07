package com.solutions.service;
import com.solutions.proyecto.Province;
import com.solutions.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceService {
    @Autowired
    private ProvinceRepository repository;

    public Province findbyId(int id){
        return repository.findById(id).get();
    }

    public List<Province> findAll() { return repository.findAll(); }
}
