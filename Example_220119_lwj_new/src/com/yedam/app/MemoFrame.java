package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.memo.Memo;
import com.yedam.app.memo.MemoDAOImpl;
import com.yedam.app.memo.memoDAO;

public class MemoFrame {
	
	private Scanner scanner = new Scanner(System.in);
	private memoDAO dao = MemoDAOImpl.getInstance();
	
	public MemoFrame() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo==1) {
				//등록
				insertMemo();
			}else if(menuNo ==2) {
				//수정
				updateMemo();
			}else if(menuNo ==3) {
				//삭제
				deleteMemo();
			}else if(menuNo ==4) {
				//단건
				selectOne();
			}else if(menuNo ==5) {
				//전체
				selectAll();
			}else if(menuNo ==9) {
				//종료
				 end();
				 break;
			}
		}
	}

	

	public void menuPrint() {
		System.out.println("=========================================================");
		System.out.println("│  1.등록 | 2.수정 | 3.삭제 | 4.메모조회 | 5.전체조회 | 9.종료  │");  
		System.out.println("=========================================================");
		System.out.println("메뉴 선택 >> ");
		
	}
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.next());
		}catch(Exception e) {
			System.out.println("없는 메뉴입니다!");
		}
		return menuNo;
	}
	public void insertMemo() {
		Memo memo = inputMemoInfo();
		dao.insert(memo);
	}
	


	public void updateMemo() {
		Memo momo = inputMemoContent();
		dao.update(momo);
	}
	



	public void deleteMemo() {
		int memoId = inputMemoId();
		dao.delete(memoId);
	}
	public void selectOne() {
		int memoId = inputMemoId();
		Memo memo = dao.slelectOne(memoId);
		if(memo == null) {
			System.out.println("해당 부서가 존재하지 않거나 오입력했습니다!");
		}else {
			System.out.println(memo);
		}
	}
	public void selectAll() {
		List<Memo> list = dao.selectAll();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	public void end() {
		System.out.println("프로그램이 종료되었습니다");
	}
	public Memo inputMemoInfo() {
		Memo memo = new Memo();
		System.out.println("메모번호 > ");
		memo.setMemoId(Integer.parseInt(scanner.next()));
		System.out.println("메모제목 > ");
		memo.setMemoTitle(scanner.next());
		System.out.println("메모작성자 > ");
		memo.setMemoWriter(scanner.next());
		System.out.println("메모내용 > ");
		memo.setMemoContent(scanner.next());
		
		return memo;
	}
	public Memo inputMemoContent() {
		Memo memo = new Memo();
		System.out.println("메모번호 > ");
		memo.setMemoId(Integer.parseInt(scanner.next()));
		System.out.println("메모내용 > ");
		memo.setMemoContent(scanner.next());
		return memo;
	}
	public int inputMemoId() {
		int memoId = 0;
		System.out.println("메모 번호 > ");
		memoId = Integer.parseInt(scanner.next());
		return memoId;
	}

}
