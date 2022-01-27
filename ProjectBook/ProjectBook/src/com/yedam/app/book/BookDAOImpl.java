package com.yedam.app.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class BookDAOImpl extends DAO implements BookDAO {
	// 싱글톤
	private static BookDAO instance = new BookDAOImpl();

	private BookDAOImpl() {	}

	public static BookDAO getInstance() {
		return instance;
	}

	@Override
	public List<Book> selectAll() {
		List<Book> list = new ArrayList();
		try {
			connect();

			String select = "select * from book order by book_name";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

	}

	@Override
	public void insert(Book book) {
		try {
			connect();
			String insert = "insert into book values(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			pstmt.setInt(4, book.getBookRental());

			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("정상등록 되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(Book book) {
		try {
			connect();
			String update = "update book set book_rental=? where book_name=?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, book.getBookRental());
			pstmt.setString(2, book.getBookName());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상 수정되었습니다");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public Book selectBook(String bookName) {
		Book book = null;
		try {
			connect();
			String select = "select * from book where book_name=?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, bookName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;

	}

}
