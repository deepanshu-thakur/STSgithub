package com.cg.bookApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookApp.model.Book;
import com.cg.bookApp.model.FavBook;
import com.cg.bookApp.service.BookAppService;
import com.cg.bookApp.exception.BookNotFoundException;
import com.cg.bookApp.exception.DuplicateBookException;

@RestController
public class BookAppController {

	@Autowired
	private BookAppService service;
	
/*======Books add,update,delete,get all books,get books by book name,get books by author name mappings starts here======*/
	
	@PostMapping(value="/books")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) throws DuplicateBookException{
	return service.addBook(book);
	}
	
	
	@GetMapping(value = "/books")
	public List<Book> getAllBooks(){
	return service.getAllBooks();
	}
	
	@GetMapping("/books/id/{id}")
	public Book getBookById(@PathVariable("id") int bookId) throws BookNotFoundException{
	return service.getBookById(bookId);
	}
	
	
	@DeleteMapping("/books/id/{id}")
	public ResponseEntity<Boolean> deleteBookByCode(@PathVariable("id") int bookId) throws BookNotFoundException
	{
	
	boolean isDeleted =  service.deleteBook(bookId);
	
	return new ResponseEntity<>(isDeleted,HttpStatus.OK);
	
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws BookNotFoundException {
	Book updatedItem = service.updateBook(book);
	return ResponseEntity.ok(updatedItem);
	}
	
	@GetMapping("/books/name/{bookName}")
	public List<Book> searchBookByName(@PathVariable String bookName) throws BookNotFoundException{
	return service.findBookByName(bookName);
	}
	
	@GetMapping("/books/author/{bookAuthor}")
	public List<Book> searchBookByAuthor(@PathVariable String bookAuthor) throws BookNotFoundException{
	return service.findBookByAuthor(bookAuthor);
	}
	
/*======Books add,update,delete,get all books,get books by book name,get books by author name mappings ends here======*/
	
/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID mappings starts here======*/
	
	@GetMapping("/books/fav/id/{id}")
	public FavBook getFavBookById(@PathVariable("id") int bookId) throws BookNotFoundException{
	return service.getFavBookById(bookId);
	}
	@DeleteMapping("/books/fav/id/{id}")
	public ResponseEntity<Boolean> deleteFavBookById(@PathVariable("id") int bookId) throws BookNotFoundException{
	boolean isDeleted =  service.deleteFavBookById(bookId);
	return new ResponseEntity<>(isDeleted,HttpStatus.OK);
	}
	@GetMapping("/books/fav")
	public List<FavBook> getAllFavBook() {
	return service.getAllFavBook();
	}
/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID mappings ends here======*/
	
	@GetMapping("/books/genre/{genre}")
	public List<Book> getRecomBookByGenre(@PathVariable("genre") String genre) throws BookNotFoundException{
	return service.findBookByGenre(genre);
	}
	
}
