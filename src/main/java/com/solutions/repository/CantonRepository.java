package com.solutions.repository;
import com.solutions.proyecto.Canton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Integer> {
}