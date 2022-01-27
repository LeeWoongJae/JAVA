package com.yedam.java.auction.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.account.Account;
import com.yedam.java.auction.Auction;
import com.yedam.java.auction.AuctionDAO;
import com.yedam.java.auction.AuctionDAOImpl;

public class AuctionFrame {
	private Scanner scanner = new Scanner(System.in);
	private AuctionDAO dao = AuctionDAOImpl.getInstance();
	Account account = new Account();
	public void run() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 매뉴선택
			int menuNo = menuSelect();
			// 각기능별 실행
			if (menuNo == 1) {
				// 경매물품등록
				insertAuctionInfo();
			} else if (menuNo == 2) {
				// 경매물품확인
				selectAuctionList();
			} else if (menuNo == 3) {
				// 경매시작
				startAuction();
			} else if (menuNo == 4) {
				// 경매물품현황
				searchAuction();
			} else if (menuNo == 9) {
				// 종료
				end();
				break;

			}
		}
	}

	public void menuPrint() { // 첫화면
		System.out.println("======================================================================");
		System.out.println("[1] 경매물품등록 |  [2] 경매물품확인 |  [3] 경매시작 | [4] 경매물품현황 | [9] 종료");
		System.out.println("======================================================================");
		System.out.println("=== 물품등록은 마스터 계정만 가능합니다. 이점 참고 부탁드립니다! ===");
		System.out.println("번호 선택을 해주세요 > ");
	}

	public int menuSelect() { // 메뉴선택
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuNo;
	}

	public void insertAuctionInfo() { // 1.경매물품등록
		if(account.getAccountId().equals("master")) {
		Auction auction = inputAuctionInfo();
		dao.insertAuction(auction);
		}else {
			System.out.println("마스터 계정만 등록이 가능합니다");	
		}
	}

	public Auction inputAuctionInfo() { // 경매물품등록
		Auction auction = new Auction();
		System.out.println("물품이름 > ");
		auction.setAuctionName(scanner.nextLine());
		System.out.println("물품설명 > ");
		auction.setAuctionContent(scanner.nextLine());
		System.out.println("물품 경매가격 > ");
		auction.setAuctionBalance(Integer.parseInt(scanner.nextLine()));
		System.out.println("낙찰 카운트 > ");
		auction.setCount(Integer.parseInt(scanner.nextLine()));
		return auction;
	}

	public void selectAuctionList() {// 경매 물품확인
		List<Auction> list = dao.selectAll();
		for (Auction auction : list) {
			System.out.println(auction);
		}

	}

	public void startAuction() { // 경매 시작
		Auction auction = new Auction();
		List<Auction> list = dao.selectAll();
		int money =0;
		if (auction.getIsSoldOut() == 0) {
			for (Auction auctionList : list) {
				System.out.println("경매물품 : " + auction.getAuctionName() + ", 물품내용 : " + auction.getAuctionContent()
						+ ", 물품경매가 : " + auction.getAuctionBalance());
				System.out.println("경매를 시작합니다");
				int cnt = 5;
				for (int i = 0; i <cnt; i++) {
					
					money = Integer.parseInt(scanner.nextLine());
					auction.setAuctionBalance(auction.getAuctionBalance()+money);
					account.setAccountBalance(money);
					if (cnt == 0) {
						break;
					}
				} // 경매시작을 누르면 경매가능한 물품들 다 출력ㅎ주고 시작하빈다
			}
		}
	}

	public void searchAuction() { // 경매현황 (경매가능만 출력)
		Auction auction = new Auction();
		if (auction.getIsSoldOut() == 0) {
			System.out.println("경매물품 : " + auction.getAuctionName() + ", 물품내용 : " + auction.getAuctionContent()
					+ ", 물품경매가 : " + auction.getAuctionBalance() + (auction.getIsSoldOut() == 0 ? "경매가능" : "경매불가"));

		}
	}

	public void end() {
		System.out.println("경매 프로그램을 종료합니다.");

	}
}
