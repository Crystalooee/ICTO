package com.samsung.biz.board;

import java.util.ArrayList;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardLListTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
	}
}
