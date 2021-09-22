package com.oktay.repositary;

import org.springframework.data.repository.CrudRepository;

import com.oktay.model.Book;


public interface Bookrepositary extends CrudRepository<Book, Integer> {

}
