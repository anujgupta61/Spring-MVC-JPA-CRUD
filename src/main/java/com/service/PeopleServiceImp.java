package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PeopleDao;
import com.entity.People;

@Service
public class PeopleServiceImp implements PeopleService {

   @Autowired
   private PeopleDao peopleDao;

   @Transactional
   public People save(People people) {
      return peopleDao.save(people);
   }
   
   @Transactional
   public People delete(int peopleId) {
      return peopleDao.delete(peopleId);
   }
   
   @Transactional
   public People update(int peopleId, String peopleName, String peopleEmail) {
      return peopleDao.update(peopleId, peopleName, peopleEmail);
   }

   @Transactional(readOnly = true)
   public List<People> list() {
      return peopleDao.list();
   }
}