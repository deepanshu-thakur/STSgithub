package com.cg.bookApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavBook {
	@Id
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String genre;
}
