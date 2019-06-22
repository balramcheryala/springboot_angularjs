package com.sutiboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutiboot.domain.Person;
import com.sutiboot.repository.PersonRepository;

/**
 * @className:com.sutiboot.service.PersonService.java
 * @author <a href="mailto:balramc@****.**">Balram</a>
 * @date May 23, 2019 2:35:10 PM
 * @description:
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    @PersistenceContext
    private EntityManager em;

    public Object findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
    	
        return em.find(Person.class, id);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }
    
    public void delete(long id) {

    	personRepository.deleteById(id);

    }
}
