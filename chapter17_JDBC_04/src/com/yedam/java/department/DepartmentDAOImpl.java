package com.yedam.java.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class DepartmentDAOImpl extends DAO implements DepartmentDAO {

	// singleton
	public static DepartmentDAO instance = new DepartmentDAOImpl();

	private DepartmentDAOImpl() {
	}

	public static DepartmentDAO getInstance() {
		return instance;
	}

	@Override
	public List<Department> selectAll() {
		List<Department> list = new ArrayList<>();
		try {
			connect();
			String select = "select * from departments where department_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Department dept = new Department();

				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getInt("location_id"));
				dept.setManagerId(rs.getString("manager_id"));

				list.add(dept);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}

		return list;
	}

	@Override
	public Department selectOne(int departmentId) {
		Department dept = null;
		try {
			connect();
			String select = "SELECT * FROM departments WHERE department_id=?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, departmentId);// 매개변수의 순서와 변수명을 넣는다
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getInt("location_id"));
				dept.setManagerId(rs.getString("manager_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return dept;

	}

	@Override
	public void insert(Department dept) {

		try {
			connect();
			String insert = "INSERT INTO departments VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getLocationId());
			pstmt.setString(4, dept.getManagerId());

			int result = pstmt.executeUpdate(); // 정수 반환
			System.out.println(result + "건이 등록되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(Department dept) {
		try {
			connect();
			String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());

			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void delete(int departmentId) {
		try {
			connect();
			String delete = "DELETE FROM departments WHERE department_id=?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, departmentId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
