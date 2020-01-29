package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class MemberDAO2 {

	private DataSource dataFactory;

	public MemberDAO2() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "update member2 set name=?, age=? where id=?";

		try {
			conn = dataFactory.getConnection();
			pt = conn.prepareStatement(sql);
			pt.setString(1, dto.getName());
			pt.setInt(2, dto.getAge());
			pt.setString(3, dto.getId());
			pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pt, conn);
		}

	}

	public MemberDTO updateui(String id) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "select * from member2 where id=?";
		MemberDTO dto = null;
		try {
			conn = dataFactory.getConnection();
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pt, conn);
		}
		return dto;

	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberDTO read(String id) {
		MemberDTO dto = null;

		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "select * from member2 where id= ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");

				dto = new MemberDTO(id, name, age);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pt, conn);
		}

		return dto;

	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "insert into member2(id,name,age)values(?,?,?)";

		try {
			conn = dataFactory.getConnection();
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

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * form member2";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list.add(new MemberDTO(id, name, age));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);

		}
		return list;
	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "delete from member2 where id = ?";
		try {
			conn = dataFactory.getConnection();
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			pt.executeUpdate();
			// 결과값이 있는 메소드도 반드시 반환할 필요는 없다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pt, conn);
		}

	}

	public MemberDTO login(String id, int age) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pt = null;
		String sql = "select * from member2 where id= ? and age = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			pt.setInt(2, age);
			rs = pt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				dto = new MemberDTO(id, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pt, conn);
		}

		return dto;
	}

}
