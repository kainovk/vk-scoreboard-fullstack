package com.vk.vktasktracker.service;

import com.vk.vktasktracker.exception.NotFoundException;
import com.vk.vktasktracker.model.Person;
import com.vk.vktasktracker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }
}
