package com.solutions.repository;
import com.solutions.proyecto.AppUser;
import com.solutions.proyecto.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProfessorRepository  extends JpaRepository<Professor, Integer>{


    @Modifying
    @Query(value = "{ call Add_Professor (:email, :password, :name, :lastName, :phone, :is_admin) }", nativeQuery = true)
    void insertProfessor(@Param("email") String email, @Param("password") String password,
                         @Param("name") String name, @Param("lastName") String last_name,
                         @Param("phone") String phone, @Param("is_admin") boolean is_admin);

    @Modifying
    @Query(value = "{ call UpdateProfessor (:ProfessorId, :Password, :URLPhoto, :Name, :LastName, :Phone, :Province, :Canton, :District, :Interest) }", nativeQuery = true)
    void updateProfessor(@Param("ProfessorId") Integer professorId, @Param("Password") String password,@Param("URLPhoto") byte[] url_photo,@Param("Name") String name,
                         @Param("LastName") String last_name, @Param("Phone") String phone,
                         @Param("Province") Integer province, @Param("Canton") Integer canton, @Param("District") Integer district, @Param("Interest") String interest);

    @Modifying
    @Query(value = "{ call Delete_Professor (:Professor_id) }", nativeQuery = true)
    void deleteProfessor(@Param("Professor_id") Integer id);

    @Modifying
    @Query(value = "{ call AssignProfessorAdmin (:ProfessorId) }", nativeQuery = true)
    void AssignProfessorAdmin(@Param("ProfessorId") Integer id);

    @Modifying
    @Query(value = "{ call DisableProfessor (:ProfessorId) }", nativeQuery = true)
    void DisableProfessor(@Param("ProfessorId") Integer id);

//    @Modifying
//    @Query(value = "{ call FindProfessorByEmail (:email) }", nativeQuery = true)
    @Query(value = " SELECT * FROM   Professor p, App_User a WHERE p.App_User =a.App_User_Id and a.Email= :email", nativeQuery = true)
    Professor findProfessorByEmail(@Param("email") String email);

}
