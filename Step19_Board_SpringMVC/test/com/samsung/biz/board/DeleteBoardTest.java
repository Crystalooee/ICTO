package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class DeleteBoardTest {

	public static void main(String[] args) {
		
		BoardVO vo = new BoardVO();
		vo.setSeq(21);
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
	}
}
