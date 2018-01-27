package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.People;

@Repository // Optional
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
