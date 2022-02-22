package com.cg.bookApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookApp.model.Book;
import com.cg.bookApp.model.FavBook;
import com.cg.bookApp.repository.BookAppJpaRepo;
import com.cg.bookApp.repository.FavBookRepo;
import com.cg.bookApp.exception.BookNotFoundException;
import com.cg.bookApp.exception.DuplicateBookException;

@Service
public class BookAppServiceImpl implements BookAppService {

	@Autowired
	private BookAppJpaRepo repo;
	
	@Autowired
	private FavBookRepo favRepo;
	
	FavBook fb = new FavBook();
	
/*======Books add,update,delete,get all books,get books by book name,get books by author name functions starts here======*/
	@Override
	public Book addBook(Book book) throws DuplicateBookException
	{
		if(repo.existsById(book.getBookId())) {
			throw new DuplicateBookException("Book with ID - "+book.getBookId()+" already exists");
		}
		return repo.save(book);
	}
	
	@Override
	public Book getBookById(int bookId) throws BookNotFoundException
	{
		if(!repo.existsById(bookId)) {
			throw new BookNotFoundException("Book with ID - "+bookId+" Not Found..");
		}
		return repo.findById(bookId).get();
	}
	
	@Override
	public Book updateBook(Book book) throws BookNotFoundException
	{
		if(!repo.existsById(book.getBookId())) {
			throw new DuplicateBookException("Book with ID - "+book.getBookId()+" doesn't exists");
		}
		return repo.save(book);
	}
	
	@Override
	public boolean deleteBook(int bookId) throws BookNotFoundException
	{
		if(!repo.existsById(bookId)) {
			throw new BookNotFoundException("Book with ID - "+bookId+" Not Found..");
		}
		repo.deleteById(bookId);
		return !repo.existsById(bookId);
	}
	
	@Override
	public List<Book> getAllBooks()
	{
		return repo.findAll();
	}
	
	@Override
	public List<Book> findBookByName(String bookName) throws BookNotFoundException
	{
		if(!repo.existsByBookName(bookName)) {
			throw new BookNotFoundException("Book with Name - "+bookName+" Not Found..");
		}
		return repo.findByBookName(bookName);
	}
	
	@Override
	public List<Book> findBookByAuthor(String bookAuthor) throws BookNotFoundException
	{
		if(!repo.existsByBookAuthor(bookAuthor)) {
			throw new BookNotFoundException("Book with Author Name - "+bookAuthor+" Not Found..");
		}
		return repo.findByAuthorName(bookAuthor);
	}
	
	@Override
	public List<Book> findBookByGenre(String genre) throws BookNotFoundException
	{
		if(!repo.existsByGenre(genre)) {
			throw new BookNotFoundException("Book with Genre - "+genre+" Not Found..");
		}
		return repo.findByGenre(genre);
	}
/*======Books add,update,delete,get all books,get books by book name,get books by author name functions ends here======*/

/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID functions starts here======*/

	@Override
	public FavBook getFavBookById(int bookId) throws BookNotFoundException
	{
		if(!repo.existsById(bookId)) {
			throw new BookNotFoundException("Favorite Book with ID - "+bookId+" Not Found..");
		}
		Book book = repo.findById(bookId).get();
		fb.setBookId(book.getBookId());
		fb.setBookName(book.getBookName());
		fb.setBookAuthor(book.getBookAuthor());
		fb.setGenre(book.getGenre());
		return favRepo.save(fb);
	}
	
	@Override
	public List<FavBook> getAllFavBook()
	{
		return favRepo.findAll();
	}
	
	@Override
	public boolean deleteFavBookById(int bookId) throws BookNotFoundException
	{
		if(!favRepo.existsById(bookId)) {
			throw new BookNotFoundException("Favorite Book with ID - "+bookId+" Not Found..");
		}
		favRepo.deleteById(bookId);
		return !favRepo.existsById(bookId);
	}
/*======Add a book as favorite, get all favorite books, delete a favorite book by book ID functions ends here======*/

}
