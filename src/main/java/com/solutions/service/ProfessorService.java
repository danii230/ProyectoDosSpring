package com.solutions.service;
import com.solutions.proyecto.AppUser;
import com.solutions.proyecto.Professor;
import com.solutions.repository.AppUserRepository;
import com.solutions.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.Authenticator;
import java.security.AuthProvider;
import java.util.List;

@Service
@Transactional

public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private AppUserRepository repositoryAppUser;

    public List<Professor> findAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Professor findById(Integer id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    //Stored procedures
    public void deleteProfessor(Integer id) {
        try {
            repository.deleteProfessor(id);
        }catch(Exception ex) {

         System.out.println(ex.getMessage());
        }
    }

    public void insertProfessor (Professor professor) {
        try {
            repository.insertProfessor(professor.getApp_user().getEmail(), professor.getApp_user().getPassword(),
                    professor.getApp_user().getName(), professor.getApp_user().getLast_name(),
                    professor.getApp_user().getPhone(), professor.getApp_user().getProvince().getProvince_id(),professor.getApp_user().getCanton().getCanton_id(),professor.getApp_user().getDistrict().getDistrict_id(),professor.isIs_admin());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateProfessor (Professor professor) {
        try {
            repository.updateProfessor(professor.getProfessor_id(), professor.getApp_user().getPassword(),professor.getApp_user().getUrl_Photo(),professor.getApp_user().getName(),
                    professor.getApp_user().getLast_name(), professor.getApp_user().getPhone(),professor.getApp_user().getProvince().getProvince_id(),professor.getApp_user().getCanton().getCanton_id(),professor.getApp_user().getDistrict().getDistrict_id(),professor.getApp_user().getInterest());
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AssignProfessorAdmin(Integer id) {
        try {
            repository.AssignProfessorAdmin(id);
        }catch(Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void DisableProfessor(Integer id) {
        try {
            repository.DisableProfessor(id);
        }catch(Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
