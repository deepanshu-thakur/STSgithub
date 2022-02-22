package com.cg.bookApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bookApp.model.Book;


public interface BookAppJpaRepo extends JpaRepository<Book, Integer>{
	
	@Query("from Book where bookName=:bookName")
	public List<Book> findByBookName(String bookName);
	public boolean existsByBookName(String bookName);
	
	@Query("from Book where bookAuthor=:bookAuthor")
	public List<Book> findByAuthorName(String bookAuthor);
	public boolean existsByBookAuthor(String bookAuthor);
	
	@Query("from Book where genre=:genre")
	public List<Book> findByGenre(String genre);
	public boolean existsByGenre(String genre);
}
