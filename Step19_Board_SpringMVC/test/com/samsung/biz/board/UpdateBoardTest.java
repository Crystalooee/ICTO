package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class UpdateBoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("New Title");
		vo.setContent("New Content");
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
	}
}
