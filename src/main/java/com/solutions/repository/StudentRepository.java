package com.solutions.repository;

import com.solutions.proyecto.Professor;
import com.solutions.proyecto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    @Modifying
    @Query(value = "{ call Add_Student (:email, :password, :name, :lastName, :phone, :province, :canton, :district) }", nativeQuery = true)
    void insertStudent(@Param("email") String email, @Param("password") String password,
                         @Param("name") String name, @Param("lastName") String last_name,
                         @Param("phone") String phone, @Param("province") int province,
                         @Param("canton") int canton, @Param("district") int district);

    @Modifying
    @Query(value = "{ call UpdateStudent (:StudentId, :Password, :URLPhoto, :Name, :LastName, :Phone, :Province, :Canton, :District, :Interest) }", nativeQuery = true)
    void updateStudent(@Param("StudentId") Integer studentId, @Param("Password") String password,@Param("URLPhoto") byte[] url_photo,@Param("Name") String name,
                         @Param("LastName") String last_name, @Param("Phone") String phone,
                         @Param("Province") Integer province, @Param("Canton") Integer canton, @Param("District") Integer district, @Param("Interest") String interest);

    @Modifying
    @Query(value = "{ call Delete_Student (:Student_id) }", nativeQuery = true)
    void deleteStudent(@Param("Student_id") Integer id);

    @Modifying
    @Query(value = "{ call Update_Admited_Student (:Student_id) }", nativeQuery = true)
    void admitedStudent(@Param("Student_id") Integer id);

    @Modifying
    @Query(value = "{ call Assign_Student_President (:Student_id) }", nativeQuery = true)
    void assingStudentPresident(@Param("Student_id") Integer id);

    @Modifying
    @Query(value = "{ call Disable_Student (:Student_id) }", nativeQuery = true)
    void disableStudent(@Param("Student_id") Integer id);

    @Modifying
    @Query(value = "{ call View_Student_unacceptable }", nativeQuery = true)
    List<Student> getOutsatandingStudent();

//    @Modifying
//    @Query(value = "{ call FindStudentByEmail (:email) }", nativeQuery = true)
//    Student findStudentByEmail(@Param("email") String email);

    @Query(value = " SELECT * FROM   Student s, App_User a WHERE s.App_User = a.App_User_Id and a.Email= :email", nativeQuery = true)
    Student findStudentByEmail(@Param("email") String email);

}
