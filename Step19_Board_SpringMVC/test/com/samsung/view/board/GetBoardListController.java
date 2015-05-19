package com.samsung.view.board;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null){
			mav.setViewName("login.jsp");
			return mav;
		}
		
		String searchCondition = "";
		String searchKeyword = "";
		
		if(request.getParameter("searchCondition") == null){
			searchCondition = "TITLE";
		}else{
			searchCondition = request.getParameter("searchCondition");
		}
		if(request.getParameter("searchCondition") == null){
			searchKeyword = "";
		}else{
			searchKeyword = request.getParameter("searchKeyword");
		}
		
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO dao = new BoardDAO();

		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		System.out.println(boardList);
		request.setAttribute("boardList", boardList);
		RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
	
}
