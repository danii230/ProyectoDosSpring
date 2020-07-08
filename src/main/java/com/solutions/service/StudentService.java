package com.solutions.service;

import com.solutions.proyecto.Professor;
import com.solutions.proyecto.Student;
import com.solutions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Student findById(Integer id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void deleteStudent(Integer id) {
        try {
            repository.deleteStudent(id);
        }catch(Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void insertStudent (Student student) {
        try {
            repository.insertStudent(student.getApp_user().getEmail(), student.getApp_user().getPassword(),
                    student.getApp_user().getName(), student.getApp_user().getLast_name(),
                    student.getApp_user().getPhone(), student.getApp_user().getProvince().getProvince_id(),student.getApp_user().getCanton().getCanton_id(),student.getApp_user().getDistrict().getDistrict_id());
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateStudent (Student student) {
        try {
            repository.updateStudent(student.getStudent_id(), student.getApp_user().getPassword(),student.getApp_user().getUrl_Photo(),student.getApp_user().getName(),
                    student.getApp_user().getLast_name(), student.getApp_user().getPhone(),student.getApp_user().getProvince().getProvince_id(),student.getApp_user().getCanton().getCanton_id(),student.getApp_user().getDistrict().getDistrict_id(),student.getApp_user().getInterest());
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void admitedStudent (Integer id){
        try {
            repository.admitedStudent(id);
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void assingStudentPresident (Integer id){
        try {
            repository.assingStudentPresident(id);
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void disableStudent (Integer id){
        try {
            repository.disableStudent(id);
        }

        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Student> viewStudentUnacceptable() {
        try {
            return repository.viewStudentUnacceptable();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
