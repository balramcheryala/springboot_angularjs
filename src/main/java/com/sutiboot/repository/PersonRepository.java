package com.sutiboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sutiboot.domain.Person;

/**
 * @className:com.sutiboot.repository.PersonRepository.java
 * @author <a href="mailto:balramc@****.**">Balram</a>
 * @date May 23, 2019 2:35:02 PM
 * @description:
 */
@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
