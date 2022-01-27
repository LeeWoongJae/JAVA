
public class Book {//책정보를 받고 넘기는 VO
	private String bookName;
	private String bookWriter;
	private String bookContent;
	private int bookRental;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	
	public int getBookRental() {
		return bookRental;
	}
	public void setBookRental(int bookRental) {
		this.bookRental = bookRental;
	}
	@Override
	public String toString() {
		return "책제목 : " + bookName + ", 저자명 : " + bookWriter + ", 내용 : " + bookContent
				+ ", 대여여부 : " + bookRental;
	}
	
	
}
