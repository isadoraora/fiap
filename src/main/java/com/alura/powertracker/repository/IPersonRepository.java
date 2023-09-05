package com.alura.powertracker.repository;

import com.alura.powertracker.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> { }
