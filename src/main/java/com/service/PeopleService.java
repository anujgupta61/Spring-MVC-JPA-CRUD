package com.service;

import java.util.List;

import com.entity.People;

public interface PeopleService {
	
	People save(People people);

	People delete(int peopleId);

	People update(int peopleId, String peopleName, String peopleEmail);

	List<People> list();
}