package com.solutions.proyecto.repository;

import com.solutions.proyecto.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Modifying
    @Query(value = "{ call Add_Professor (:email, :password, :name, :last_name, :phone, :is_admin) }", nativeQuery = true)
    void insertProfessor(@Param("email") String email, @Param("password") String password,
                       @Param("name") String name, @Param("last_name") String last_name,
                       @Param("phone") String phone, @Param("is_admin") boolean is_admin);

    @Modifying
    @Query(value = "{ call UpdateProfessorByAdmin (:ProfessorId, :Name, :Last_name, :Phone) }", nativeQuery = true)
    void updateProfessor(@Param("ProfessorId") Integer professorId, @Param("Name") String name,
                         @Param("Last_name") String last_name, @Param("Phone") String phone);

    @Modifying
    @Query(value = "{ call Delete_Professor (:Professor_id) }", nativeQuery = true)
    void deleteProfessor(@Param("Professor_id") Integer id);
}
