package com.cg.bookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookApp.model.FavBook;

public interface FavBookRepo extends JpaRepository<FavBook, Integer>{

}
