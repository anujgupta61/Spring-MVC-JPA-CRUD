package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.PeopleDao;
import com.entity.People;
import com.repository.PeopleRepository;

@Repository
public class PeopleDaoImp implements PeopleDao {

	@Autowired
	private PeopleRepository peopleRepository;

	public People save(People people) {
		return peopleRepository.save(people);
	}

	public People delete(int peopleId) {
		People people = peopleRepository.findOne(peopleId);
		peopleRepository.delete(people);
		return people;
	}

	public People update(int peopleId, String peopleName, String peopleEmail) {
		People people = peopleRepository.findOne(peopleId);
		people.setName(peopleName);
        people.setEmail(peopleEmail);
        return peopleRepository.save(people);
	}

	public List<People> list() {
		return peopleRepository.findAll();
	}
}