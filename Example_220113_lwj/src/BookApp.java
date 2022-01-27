import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		BookDAO dao = BookDAO.getInstance();
		List<Book> list = new ArrayList<>();
		Book book = null;
		String bookName;
		String bookContent;
		while (run) {
			System.out.println("==================================================================================");
			System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 |5.책 대여 | 6.책 반납 | 7.책 등록 | 9. 종료");
			System.out.println("==================================================================================");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:// 전체조회
				list = dao.selectAll();
				for (Book bookList : list) {
					System.out.println(bookList);
				}
				break;
			case 2: // 단건 검색
				System.out.println("조회할 책 이름을 입력해줘세요 > ");
				bookName = scanner.nextLine();
				book = dao.selectOne(bookName);
				System.out.println(book);
				break;
			case 3:// 내용 검색
				
				System.out.println("검색할 책의 내용을 입력 > ");
				bookContent = scanner.nextLine();
				
//				book = dao.selectContent(bookContent);
//				for(int i=0;i<list.size();i++) {
//					book = list.get(i);
//				for (Book bookList : list) {
//						book = dao.selectContent(bookContent);
//						System.out.println(book);
//					}

				book = dao.selectContent(bookContent);
				System.out.println(book);
				
				break;
			case 4:// 대여가능 출력
				list = dao.selectAll();
				for (Book bookList : list) {
					if (bookList.getBookRental() == 1) {
						System.out.println(bookList);
					}
				}

				break;
			case 5:// 책대여
				System.out.println("대여할 책 이름을 입력 > ");
				bookName = scanner.nextLine();
				for (Book b : list) {
					if (b.getBookName() == bookName) {
						 		b.getBookRental(); 
						if (b.getBookRental()==1) {
							b.setBookRental(0);
							System.out.println("해당 책을 대여하였습니다");
						} else {
							System.out.println("해당책은 이미 대여되어있습니다");
						}
					}
				}
//				book = new Book();
//				System.out.println("대여할 책 이름을 입력 > ");
//				book.setBookName(scanner.nextLine());
//				dao.rentalBook(book);
				break;
			case 6:// 책반납
				System.out.println("반납할 책 이름을 입력 > ");
				bookName = scanner.nextLine();
				for (Book b : list) {
					if (b.getBookName().equals(bookName)) {
						if (b.getBookRental() == 1) {
							System.out.println("해당책은 이미 반납되어있습니다");
						} else {
							b.setBookRental(1);
							System.out.println("해당 책을 반납하였습니다");
						}
					}
				}
				break;
			case 7:// 책등록
				book = new Book();
				System.out.println("책 이름>");
				book.setBookName(scanner.nextLine());
				System.out.println("저자 이름>");
				book.setBookWriter(scanner.nextLine());
				System.out.println("책 내용>");
				book.setBookContent(scanner.nextLine());
				book.setBookRental(1);
				dao.insert(book);
				break;
			case 9:
				run = false;
				System.out.println("프로그램이 종료됩니다");
				break;
			}
		}

	}

}
