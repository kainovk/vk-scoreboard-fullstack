package com.example.vktasktracker.repository;

import com.example.vktasktracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
