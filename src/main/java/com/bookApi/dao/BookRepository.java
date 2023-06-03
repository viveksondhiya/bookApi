package com.bookApi.dao;

import com.bookApi.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
