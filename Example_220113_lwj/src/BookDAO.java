import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	// DB연걸
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/D:/DEV/workspace/YedamDataBase.db";
	// 필드
	Connection conn = null; // DB연결을 위해서
	PreparedStatement pstmt = null;
	ResultSet rs = null; // 결과값을 가져오는 변수클래스

	// 싱글톤 구성 > 다른 접근을 허용하지 않기위해서
	private static BookDAO instance = new BookDAO();

	private BookDAO() {
	}

	public static BookDAO getInstance() {
		return instance;
	}

	// 메서드

	// JDBC 로딩
	// DB연결

	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩 실패하였습니다");
		} catch (SQLException e) {

			System.out.println("DB와 연걸이 실패하였습니다");
		}

	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("자원이 정상적으로 해체되지 못했습니다");
		}

	}

	public List<Book> selectAll() {
		List<Book> list = new ArrayList();
		try {
			connect();
			String select = "SELECT * FROM book order by book_name";
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

	public Book selectOne(String bookName) {
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_name=?";
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

	public Book selectContent(String bookContent) {
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_content like '%'||?||'%'";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, bookContent);
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

	public Book bookRental(int bookRental) {
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_rental=?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, bookRental);
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
	public void update(Book book) {
		try {
			connect();
			String update="UPDATE book SET book_name = ?";
			pstmt= conn.prepareStatement(update);
			pstmt.setString(1, book.getBookName());
			int result  = pstmt.executeUpdate();
			System.out.println("책제목 : "+book.getBookName()+", 저자명 : "+book.getBookWriter()+", 내용 :"+book.getBookContent()+", 대여여부"+book.getBookRental());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public void insert(Book book) {
		try {
			connect();
			String insert = "INSERT INTO book values(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			pstmt.setInt(4, book.getBookRental());
			int result = pstmt.executeUpdate();
			System.out.println(result+"권의 책이 등록 되었습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

}
//전제조회 select 대여여부bookrental 업데이트 update 메서드