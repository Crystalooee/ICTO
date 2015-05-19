package com.samsung.biz.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samsung.biz.common.JDBCUtils;
import com.samsung.biz.user.vo.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public UserVO login(UserVO vo) {
		// System.out.println(vo);

		UserVO user = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from users where id = ? and password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());

			rs = stmt.executeQuery();
			if (rs.next()) {

				user = new UserVO(); // 객체가 존재하지 않으면 null값이 return.

				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}

		return user;

	}

	public void logout() {

	}
}
