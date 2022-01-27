package homework220107;

public class Book {

	// 필드
	private String bookName;
	private String returnBook;
	private String personName;
	private  int serial ;
	private String possible = "";
	private boolean rentalAnswer;
	
	
	
	//생성자
	Book(String bookName){
		this.bookName = bookName;
	}
	Book(String bookName , String personName ){
		this.bookName = bookName;
		this.personName = personName;
	}
	Book(int serial, String bookName, String personName){
		this.serial = serial;
		this.bookName = bookName;
		this.personName = personName;
	}
	
	//메서드
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getSerial() {
		return serial;
	}
	public int setSerial(int serial) {
		this.serial = serial;
		return serial;
	}
	public String getPossible() {
		return possible;
	}
	public void setPossible(String possible) {
		this.possible = possible;
	}
	public String getReturnBook() {
		return returnBook;
	}
	public void setReturnBook(String returnBook) {
		this.returnBook = returnBook;
	}
	public boolean isRentalAnswer() {
		return rentalAnswer;
	}
	public void setRentalAnswer(boolean rentalAnswer) {
		this.rentalAnswer = rentalAnswer;
	}
	
	
}
