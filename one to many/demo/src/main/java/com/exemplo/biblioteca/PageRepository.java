package com.exemplo.biblioteca;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.domain.Sort;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}