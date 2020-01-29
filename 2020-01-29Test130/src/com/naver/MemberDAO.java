package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "ca2";
	public static final String PASSWORD = "ca2";

	public MemberDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "insert into member2(id,name,age)values(?,?,?)";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getName());
			pt.setInt(3, dto.getAge());
			pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pt, conn);
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public List<MemberDTO> select() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "select * from member2";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pt, conn);
		}
		return list;
	}
}
