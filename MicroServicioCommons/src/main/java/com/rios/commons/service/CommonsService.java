package com.rios.commons.service;

import java.util.Optional;


public interface CommonsService <E> {
	public Iterable<E> findAll();
	public Optional<E> findById(Long Id);
	public E save(E entity);
	public void deleteById(Long Id);
}
