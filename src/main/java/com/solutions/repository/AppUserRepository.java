package com.solutions.repository;
import com.solutions.proyecto.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
