package com.yedam.app.book;

import java.util.List;

public interface BookDAO { //db와 소통하기위한 인터페이스
	
	//전체조회
	public List<Book> selectAll();
	
	//등록
	public void insert(Book book);
	
	//수정
	public void update(Book book);
	
	//단건조회
	public Book selectBook(String bookName);
	
}
