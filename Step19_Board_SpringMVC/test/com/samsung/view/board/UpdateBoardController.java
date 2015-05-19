package com.samsung.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {

			mav.setViewName("login.jsp");
			return mav;
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(seq);

		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);

		mav.setViewName("getBoardList.do");
		return mav;
	}

}
