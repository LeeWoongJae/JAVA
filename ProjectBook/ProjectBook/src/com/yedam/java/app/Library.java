package com.yedam.java.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.yedam.app.book.Book;
import com.yedam.app.book.BookDAO;
import com.yedam.app.book.BookDAOImpl;

public class Library { //Frame 하고 동일
	private Scanner scanner = new Scanner(System.in);
	private BookDAO dao = BookDAOImpl.getInstance();
	
public Library() {
	while(true) {
		menuPrint();
		
		int menuNo = menuSelect();
		
		if(menuNo ==1 ) {
		//전체 조회
		selectBookList();
		}else if(menuNo==2) {
		//단건조회	
			selectBookInfo();
		}
		else if(menuNo==3) {
			//내용검색
			selectSearchBookList();
		}else if(menuNo==4) {
			//대여가능
			selectRentalBookList();
		}else if(menuNo==5) {
			//책대여
			rentalBook();
		}else if(menuNo==6) {
			//책반남
			returnBook();
		}else if(menuNo==7) {
			//책등록
			insertBookInfo();
		}else if(menuNo==9) {
			//종료
		end();
		break;
		}
		
	}
		
			
	}

	public void menuPrint() {
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책대여 | 6.책반납 | 7.책등록 | 9.종료");
		System.out.println("선택 >> ");
	}
	public int menuSelect() {
		int menuNo  =0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		}
		catch(Exception e) {
			System.out.println("없는 메뉴입니다");
		}
		finally {
			
		}
		return menuNo;
	}
	public void end() {
		System.out.println("프로그램 종료");
	}
	public void insertBookInfo() {
		//책 정보 입력
		Book book = inputBookInfo();
		//책 정보 동록
		dao.insert(book);
				
	}
	public void rentalBook() {
		
		//책재목 입력
		String bookName= inputBookName();
		
		//해당북 정보조회
		Book book = dao.selectBook(bookName);
		
		//대여여부확인
		if(book != null) {
			//대여가 된 경우 별도 안내문구
			if(book.getBookRental()==1) {
				System.out.println("해당책은 대여중입니다");
			}else {
				//대여가 안된경우 대여처리
				book.setBookRental(1);
				dao.update(book);
			}
				
		}else {
			System.out.println("해당하는정보가 존재하지 않습니다");
		}
		
	
		
	}
	public void returnBook() {
		//채 제목 입력
		String bookName = inputBookName();
		//책 정보확인
		Book book = dao.selectBook(bookName);
		//반납처리(직접받고 처리 // 상대가 가지고 있다고 생각 // 대여가능여부 필요없음)
		
		if(book!=null) {//책이 존재한다면
			//반납처리
		book.setBookRental(0);
		dao.update(book); // 대여가능 여부의 내용이 수정되었으니 update
		}else {
			System.out.println("해당하는 정보가 존재하지 없습니다");
		}
	} 
	//전체조회
	public void selectBookList() {
		List<Book> list = dao.selectAll();
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	public void selectBookInfo() {
		//책 제목 입력
		String bookName = inputBookName();
		
		Book book = dao.selectBook(bookName);
		
		if(book != null) {
			System.out.println(book);
		}else {
			System.out.println("해당하는 정보가 존재하지 않습니다");
		}
		
	}
	public void selectSearchBookList() {
		String keyword = inputBookKeyword();
		//키워드를 사용하여 북에 있는 수많은 리스트를 확인
		
		List<Book> list = dao.selectAll();
		//리스트를 불러온다
		
		for(Book book : list) {
			if(book.getBookContent().indexOf(keyword) != -1) {
				//인덱스값이 양수이면 존재한다고 확신가능
				System.out.println(book);
			}
		}
	}
	//대여가능 리스트
	public void selectRentalBookList() {
		List<Book> list = dao.selectAll();
		//전체값을 가져와서 자바에서 검색
		for(Book book : list) {
			if(book.getBookRental() ==0) {
				// 0 이라면 false 이므로 대여가 가능하여
				System.out.println(book);
			}
		}
	}
	//책정보를 입력받을떄마다 불려가는 메서드
	public Book inputBookInfo() {
		Book book = new Book();
		System.out.println("책재목 : ");
		book.setBookName(scanner.nextLine());
		System.out.println("저자 : ");
		book.setBookWriter(scanner.nextLine());
		System.out.println("책내용 : ");
		book.setBookContent(scanner.nextLine());
		return book; //입력받은 책정보들을 리턴
			
	}
	//책 제목 기입하는 메서드
	public String inputBookName() {
		System.out.println("책제목 > ");
		return scanner.nextLine();
	}
	//책의 제목에 대한 키워드 를 검색
	public String inputBookKeyword() {
		System.out.println("검색 > ");
		return scanner.nextLine();
	}
}


