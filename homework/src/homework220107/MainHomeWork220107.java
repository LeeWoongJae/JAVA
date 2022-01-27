package homework220107;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHomeWork220107 {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		List<Book> list = new ArrayList<Book>();
		while (run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.정보 입력 | 2.전체조회 | 3.단건조회 | 4.대여 | 5.반납 | 6.종료");
			System.out.println("----------------------------------------------------");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: // 정보 기입
				while (true) {
					System.out.print("책이름을 입력> ");
					String bookName = scanner.next();
					if (bookName.equals("q")) {
						break;
					}
					System.out.println("저자를 입력> ");
					String personName = scanner.next();
					Book book = new Book(bookName, personName);
					book.setRentalAnswer(true);
					list.add(book);
				}
				break;
			case 2: // 전체조회
				int serial = 220107;
				for (int i = 0; i < list.size(); i++) {

					Book temp = list.get(i);
					temp.setSerial(i + serial);
//					if ((list.get(i).getBookName().isEmpty())) {// 비어있는것이냐 ? 맞으면 "대여중"
//						list.get(i).setRentalAnswer(false); // 비어있으니 답은 "대여중" 출력
//					}
//					else {
//						list.get(i).setRentalAnswer(true);
//					}
					if (temp.isRentalAnswer()) { // 대답에 대한 질의 대답이 true면 대여가능 / false면 대여중
						temp.setPossible("대여가능");
					} else {
						temp.setPossible("대여중");
					}
					System.out.println(temp.getSerial() + ") 책이름 : " + temp.getBookName() + " 저자 : "
							+ temp.getPersonName() + "  " + temp.getPossible());
				}
				break;

//            for (Book temp : list) {
//               System.out.println(temp.getBookName() + " : " + temp.getPersonName());
//            }

			case 3: // 단건 조회
				System.out.println("조회할 책이름을 입력해주세요 >");
				String searchBookName = scanner.next();
				for (int i = 0; i < list.size(); i++) {
					Book temp = list.get(i);

					if (list.get(i).getBookName().contains(searchBookName)) {
						System.out.println(temp.getSerial() + ") 책이름 : " + temp.getBookName() + "	 저자 : "
								+ temp.getPersonName() + "   " + temp.getPossible());
						break;
					}
				}
				break;
			case 4: // 대여

				System.out.println("대여하실 책의 이름을 알려주세요 >>");
				String rentalBook = scanner.next();
				for (int i = 0; i < list.size(); i++) {
					Book temp = list.get(i);

//					if (rentalBook.equals(list.get(i).getBookName())) {
					if (list.get(i).getBookName().contains(rentalBook)) {
						if (list.get(i).isRentalAnswer() == true) {// 대여할 책(rentalBook)이 책목록에 남아 있나요?
							System.out.println("대여가 가능합니다 ( 1.yes | 2.no ) >>");
							int answer = Integer.parseInt(scanner.next());
							if (answer == 1) {
//							list.remove(i);
								list.get(i).setRentalAnswer(false);
								System.out.println("정상대여");
								break;
							} else if (answer == 2) {
								break;
							}
						} else if (list.get(i).isRentalAnswer() == false) {
							System.out.println("이미 대여중인 책입니다 !");
							temp.setPossible("대여중");
							System.out.println(temp.getBookName() + "	 저자 : " + temp.getPersonName() + "   "
									+ temp.getPossible());
							break;
						}
					} // 바깥쪽 if문 종료

				} // for문 종료
				break;
			case 5: // 반납
				System.out.println("반납하실 책이름을 알려주세요 >");
				String returnBook = scanner.next();
				for (int i = 0; i < list.size();) {
					Book temp = list.get(i);
					if (list.get(i).getBookName().contains(returnBook)) {
						if (list.get(i).isRentalAnswer() == false) {// 대여할 책(rentalBook)이 책목록에 남아 있나요?
							list.get(i).setRentalAnswer(true);
							temp.setPossible("대여가능");
							System.out.println("책을 반납하였습니다 !");
							break;
						} else {
							System.out.println("대여되지 않은 책입니다");
							break;
//							temp = new Book(returnBook);
//							temp.setRentalAnswer(true);
//							list.add(temp);

//						list.add(new Book(returnBook));
						
						}//안쪽 if문 종료
					}//바깥쪽 if문 종료
				}// for문 종료
				break;
			case 6:
				run = false;
				System.out.println("★프로그램을 종료합니다★");
				break;
			}
		}

	}

}