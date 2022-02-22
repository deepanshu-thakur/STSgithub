package com.cg.bookApp.service;

import java.util.List;

import com.cg.bookApp.model.Book;
import com.cg.bookApp.model.FavBook;



public interface BookAppService {
/*======Books add,update,delete,get all books,get books by book name,get books by author name functions starts here======*/
	
	public Book addBook(Book book);
	public Book getBookById(int bookId);
	public Book updateBook(Book book);
	public boolean deleteBook(int bookId);
	public List<Book> getAllBooks();
	
	public List<Book> findBookByName(String bookName);
	public List<Book> findBookByAuthor(String bookAuthor);
	public List<Book> findBookByGenre(String genre);
	
/*======Books add,update,delete,get all books,get books by book name,get books by author name functions ends here======*/
	
/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID functions starts here======*/
	
	public FavBook getFavBookById(int bookId);
	public List<FavBook> getAllFavBook();
	public boolean deleteFavBookById(int bookId);
	
/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID functions ends here======*/
	
}
