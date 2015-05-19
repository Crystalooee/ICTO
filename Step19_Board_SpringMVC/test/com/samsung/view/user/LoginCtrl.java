package com.samsung.view.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginCtrl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setPassword("guest123");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.login(vo);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			
			response.sendRedirect("getBoardList");
		}else{
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
