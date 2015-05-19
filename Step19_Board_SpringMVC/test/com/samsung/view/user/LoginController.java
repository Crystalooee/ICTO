package com.samsung.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

// spring Controller도 handleRequest를 구현하도록 되어있고
// 리턴타입이 ModelAndView 객체로 지정되어있다.

// Model과 view가 함께 지정 가능한 객체
// model은 request 개체에 값을 저장해주는 기능
// view는 String 타입으로 이동할 페이지를 설정하는 기능

//return되는 modelAndView 객체는 web.xml에 등록된 Spring의 DispatvherServlet 객체가 받아
//model은 request에 view는 RequestDispatcher에 담아
//처리하도록 한다.
public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setPassword("guest123");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.login(vo);
		
		ModelAndView mav = new ModelAndView();
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			
			mav.setViewName("getBoardList.do");
		}else{
			mav.setViewName("login.jsp");			
		}
		
		return mav;
	}
}
