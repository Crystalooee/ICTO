package com.samsung.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		//System.out.println(board);
		
	
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
