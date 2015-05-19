package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class AddBoardTest {

	public static void main(String[] args) {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("test 1");
		vo.setNickname("test 1");
		vo.setContent("test 1");
		vo.setUserid("guest");
		
		BoardDAO dao = new BoardDAO();
		dao.addBoard(vo);
	}
	
}
