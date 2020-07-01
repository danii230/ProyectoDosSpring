package com.solutions.proyecto.repository;

import com.solutions.proyecto.App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App_UserRepository extends JpaRepository<App_User, Integer> {
}
