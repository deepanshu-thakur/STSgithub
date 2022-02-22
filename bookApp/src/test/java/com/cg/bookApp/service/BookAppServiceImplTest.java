package com.cg.bookApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.bookApp.exception.BookNotFoundException;
import com.cg.bookApp.model.Book;
import com.cg.bookApp.model.FavBook;
import com.cg.bookApp.repository.BookAppJpaRepo;
import com.cg.bookApp.repository.FavBookRepo;



@SpringBootTest
class BookAppServiceImplTest {
	@Autowired
	private BookAppServiceImpl service;
	
	@MockBean
	private BookAppJpaRepo repo;
	
	@MockBean
	private FavBookRepo favRepo;
	
	@Test
	public void testAddBook() {
		Book book = new Book(101,"Harry","Rowling","fantasy");
		when(repo.save(book)).thenReturn(book);
		assertEquals(book,service.addBook(book));
	}
	
	@Test
	public void testGetBookById() {
		Book book = new Book(101,"Harry","Rowling","fantasy");
		when(repo.existsById(101)).thenReturn(true);
		when(repo.findById(101)).thenReturn(Optional.of(book));
		
		int bookId=101;
		Book book1 = service.getBookById(bookId);
		assertEquals(book1,book);
	}
	
	@Test
	public void testUpdateBook() {
		
		Book book = new Book(102,"Harry","Rowling","fantasy");
		when(repo.existsById(102)).thenReturn(true);
		when(repo.save(book)).thenReturn(book);
				
		Book bookNew = new Book(102,"Harry","Rowling","fantasy");
		assertEquals(book,service.updateBook(bookNew));
	}
	
	@Test
	public void testDeleteBook() {
		int bookId = 102;
		when(repo.existsById(bookId)).thenReturn(true);
		service.deleteBook(bookId);
		verify(repo,times(1)).deleteById(bookId);
	}
	
	@Test
	public void testGetAllBooks() {
		when(repo.findAll()).thenReturn(Stream.of(new Book(101,"Harry","Rowling","fantasy"),
				new Book(102,"Beasts","Rowling","fantasy")).collect(Collectors.toList()));
		assertEquals(2,service.getAllBooks().size());
	}
	
	@Test
	public void testFindBookByName() {
		
		Book book = new Book(101,"Harry","Rowling","fantasy");
		List<Book> l1 = new ArrayList<Book>();
		l1.add(book);
		when(repo.existsByBookName(book.getBookName())).thenReturn(true);
		when(repo.findByBookName("Harry")).thenReturn(l1);
		
		String bookName="Harry";
		List<Book> book1 = service.findBookByName(bookName);
		assertEquals(l1,book1);
	}
	
	@Test
	public void testFindBookByAuthor() {
		
		Book book = new Book(101,"Harry","Rowling","fantasy");
		List<Book> l1 = new ArrayList<Book>();
		l1.add(book);
		when(repo.existsByBookAuthor(book.getBookAuthor())).thenReturn(true);
		when(repo.findByAuthorName("Rowling")).thenReturn(l1);
		
		String bookAuthor="Rowling";
		List<Book> book1 = service.findBookByAuthor(bookAuthor);
		assertEquals(l1,book1);
	}
	
	@Test
	public void testFindBookByGenre() {
		
		Book book = new Book(101,"Harry","Rowling","fantasy");
		List<Book> l1 = new ArrayList<Book>();
		l1.add(book);
		when(repo.existsByGenre(book.getGenre())).thenReturn(true);
		when(repo.findByGenre("fantasy")).thenReturn(l1);
		
		String genre="fantasy";
		List<Book> book1 = service.findBookByGenre(genre);
		assertEquals(l1,book1);
	}
	
	@Test
	public void testGetFavBookById() {
		Book book = new Book(101,"Harry","Rowling","fantasy");
		when(repo.getById(101)).thenReturn(book);
		
		int bookId=101;
		Book book1 = repo.getById(bookId);
		FavBook fb = new FavBook();
		fb.setBookId(book1.getBookId());
		fb.setBookName(book1.getBookName());
		fb.setBookAuthor(book1.getBookAuthor());
		fb.setGenre(book1.getGenre());
		when(favRepo.save(fb)).thenReturn(fb);
		assertEquals(fb,fb);
	}
	
	@Test
	public void testDeleteFavBookById(){
		int bookId = 102;
		when(favRepo.existsById(bookId)).thenReturn(true);
		service.deleteFavBookById(bookId);
		verify(favRepo,times(1)).deleteById(bookId);
	}
	
	@Test
	public void testGetAllFavBook() {
		when(favRepo.findAll()).thenReturn(Stream.of(new FavBook(101,"Harry","Rowling","fantasy"),
				new FavBook(102,"Beasts","Rowling","fantasy")).collect(Collectors.toList()));
		assertEquals(2,service.getAllFavBook().size());
	}
	
}
