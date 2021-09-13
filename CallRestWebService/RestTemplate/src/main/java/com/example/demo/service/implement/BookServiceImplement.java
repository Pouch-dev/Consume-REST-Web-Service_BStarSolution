package com.example.demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;
import com.example.demo.exception.ApiRequestException;
import com.example.demo.service.BookService;

public class BookServiceImplement implements BookService{
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public <S extends Book> S save(S entity) {
		try {
			return bookDAO.save(entity);
		}catch (Exception e) {
			throw new ApiRequestException("Oops can't get all book");
		}
	}

	@Override
	public List<Book> findAll() {
		try {
			return bookDAO.findAll();
		}catch (Exception e) {
			throw new ApiRequestException("Oops can't get all book");
		}
	}

	@Override
	public Book findById(Integer id) {
		return bookDAO.findById(id).orElseThrow(() -> new ApiRequestException("Oops can't get one book"));
	}

	@Override
	public void deleteById(Integer id) {
		try {
			bookDAO.deleteById(id);
		}catch (Exception e) {
			throw new ApiRequestException("Oops can't get all book");
		}
	}
	
	
}
