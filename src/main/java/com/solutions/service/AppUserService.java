package com.solutions.service;

import com.solutions.proyecto.AppUser;
import com.solutions.proyecto.Canton;
import com.solutions.proyecto.Professor;
import com.solutions.proyecto.Student;
import com.solutions.repository.AppUserRepository;
import com.solutions.repository.ProfessorRepository;
import com.solutions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppUserService {
    @Autowired
    private ProfessorRepository repositoryP;
    @Autowired
    private StudentRepository repositoryS;
    @Autowired
    private AppUserRepository repository;


    public AppUser findbyId(int id) {
        return repository.findById(id).get();
    }

    public Professor authProfessor(String email, String password) {
        try {
            Professor professor = repositoryP.findProfessorByEmail(email);
            if (professor != null) {
                if (professor.getApp_user().getPassword().equals(password) && professor.getApp_user().isStatus() == true) {
                    return professor;
                } else{
                    return null;
                }
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Student authStudent(String email, String password) {
        try {
            Student student = repositoryS.findStudentByEmail(email);

            if (student != null && student.getApp_user().getPassword().equals(password) && student.getApp_user().isStatus() && student.isAdmited()) {
                return student;
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
