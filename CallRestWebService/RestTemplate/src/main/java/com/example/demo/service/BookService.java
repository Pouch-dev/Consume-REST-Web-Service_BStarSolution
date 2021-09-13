package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {

	void deleteById(Integer id);

	Book findById(Integer id);

	List<Book> findAll();

	<S extends Book> S save(S entity);

}
