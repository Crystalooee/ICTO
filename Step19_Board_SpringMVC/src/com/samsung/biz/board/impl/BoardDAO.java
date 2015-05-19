package com.samsung.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.samsung.biz.board.vo.BoardVO;
import com.samsung.biz.common.JDBCUtils;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public ArrayList<BoardVO> getBoardList(BoardVO vo) {

		ArrayList<BoardVO> boardList = null;

		try {
			conn = JDBCUtils.getConnection();

			
			String sql = "";
			if(vo.getSearchCondition().equals("TITLE")){
				sql = "select * from board where title like '%' || ? ||'%' order by seq desc";
				
			}else if(vo.getSearchCondition().equals("CONTENT")){
				sql = "select * from board where content like '%' || ? ||'%' order by seq desc";
				
			}
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();

			boardList = new ArrayList<>();

			BoardVO board = null;
			while (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}

		return boardList;
	}

	public BoardVO getBoard(BoardVO vo) {

		BoardVO board = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from board where seq=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());

			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}

		return board;
	}

	public void addBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into board(seq, title, nickname, content, userid) "
					+ "values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getNickname());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, vo.getUserid());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update board set title=?, content=? where seq=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from board where seq=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}

	public ArrayList<BoardVO> search(BoardVO vo) {

		ArrayList<BoardVO> boardList = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "";
			if(vo.getSearchCondition().equals("TITLE")){
				sql = "select * from board where title like '%' || ? ||'%' order by seq desc";
				
			}else if(vo.getSearchCondition().equals("CONTENT")){
				sql = "select * from board where content like '%' || ? ||'%' order by seq desc";
				
			}
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();

			boardList = new ArrayList<>();

			BoardVO board = null;
			while (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}

		return boardList;
	}
}
