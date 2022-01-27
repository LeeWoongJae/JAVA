package com.yedam.java.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.department.Department;
import com.yedam.java.department.DepartmentDAO;
import com.yedam.java.department.DepartmentDAOImpl;

public class DepartmentFrame {
	private DepartmentDAO deptDAO = DepartmentDAOImpl.getInstance();
	Scanner scanner = new Scanner(System.in);

	public DepartmentFrame() {
		while (true) {
			menuPrint(); // 전체 메뉴 출력
			int menuNo = menuSelect(); // 메뉴를 선택
			if (menuNo == 1) {// 등록
				insertDepartment();
				
			} else if (menuNo == 2) {// 수정
				updateDepartment();
				
			} else if (menuNo == 3) {// 삭제
				deleteDepartment();
				
			} else if (menuNo == 4) {// 단건조회
				selectOne();
				
			} else if (menuNo == 5) {// 전체조회
				selectAll();
				
			} else if (menuNo == 9) {// 종쵸
				end();
				
				break;
			}
		}
	}

	public void menuPrint() {
		System.out.println("=== 1.등록 | 2. 수정 | 3.삭제 | 4.단건조회 | 5.전체조회 | 9.종료 ===");
		System.out.println("선택 >");
	}

	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.next());
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다");
		}
		return menuNo;
	}

	public void insertDepartment() {

		// 부서정보를 입력
		Department dept = inputDepartmentInfo();
		// 부서정보를 등록
		deptDAO.insert(dept);
	}

	public void updateDepartment() {
		// 부서이름 입력
		Department dept = inputDepartmentName();
		// 부서이름 수정
		deptDAO.update(dept);
	}

	public void deleteDepartment() {
		// 부서 번호입력
		int departmentId = inputDepartmentId();
		// 부서정보 삭제
		deptDAO.delete(departmentId);
	}

	public void selectOne() {

		// 부서번호 입력
		int departmentId = inputDepartmentId();
		// 부서정보 조회
		Department dept = deptDAO.selectOne(departmentId);
		// 부서정보 출력
		if (dept == null) {
			System.out.println("해당부서가 존재하지 않습니다");
		} else {
			System.out.println(dept);
		}
	}

	public void selectAll() {

		// 전체 부서정보 조회
		List<Department> list = deptDAO.selectAll();
		// 전체 부서정보 출력
		for (Department dept : list) {
			System.out.println(dept);
		}
	}

	public void end() {
		System.out.println("프로그램이 종료됩니다");
	}

	public Department inputDepartmentInfo() {
		Department dept = new Department();
		System.out.println("부서번호 > ");
		dept.setDepartmentId(Integer.parseInt(scanner.next()));
		System.out.println("부서명 > ");
		dept.setDepartmentName(scanner.next());
		System.out.println("매니저 이름 > ");
		dept.setManagerId(scanner.next());
		System.out.println("지역번호 > ");
		dept.setLocationId(scanner.nextInt());
		return dept;
	}

	public Department inputDepartmentName() {
		Department dept = new Department();
		System.out.println("부서번호 > ");
		dept.setDepartmentId(Integer.parseInt(scanner.next()));
		System.out.println("부서명 > ");
		dept.setDepartmentName(scanner.next());

		return dept;
	}

	public int inputDepartmentId() {
		int departmentId = 0;
		System.out.println("부서 번호 > ");
		departmentId = Integer.parseInt(scanner.next());
		return departmentId;
	}
}
