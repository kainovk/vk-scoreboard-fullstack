package com.vk.vktasktracker.repository;

import com.vk.vktasktracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
