package com.oktay.repositary;

import org.springframework.data.repository.CrudRepository;

import com.oktay.model.Book;
import com.oktay.model.Issuebook;

public interface IssueBookRepositary extends CrudRepository<Issuebook, Integer> {

}
