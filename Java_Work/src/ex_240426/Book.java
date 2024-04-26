package ex_240426;

import java.util.zip.Inflater;

public class Book {
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	
	// getters/setters
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	// 생성자, 현재 시스템이 기보느 매개변수가 없는 생성자는 만들어줌.
	// 그런데, 각각의 파라미터의 갯수대로 생성자를 만들면, 기본을 안 만들어준다
	public Book() {	}
		
	public Book(String bookName, String bookAuthor, int bookPrice) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}
	
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice + "]";
	}
	
	
}
