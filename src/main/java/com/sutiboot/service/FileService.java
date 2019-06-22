package com.sutiboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutiboot.domain.FileUpload;
import com.sutiboot.domain.Person;
import com.sutiboot.repository.FilesRepository;

@Service
public class FileService {

	@Autowired
	private FilesRepository repository;

	@PersistenceContext
	private EntityManager em;

	public Object findAll() {
		return repository.findAll();
	}

	public Person findById(Long id) {

		return em.find(Person.class, id);
	}

	public FileUpload save(FileUpload file) {
		return repository.save(file);
	}

	public void delete(long id) {

		repository.deleteById(id);

	}
}
