package com.samsung.biz.user;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

public class LoginTest {

	public static void main(String[] args) {
		
		String id = "guest";
		String password = "guest123";
		
		
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setPassword("guest123");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.login(vo);
		
		dao.login(vo);
		
		if(user != null){
			System.out.println(user);
		}else{
			System.out.println("User가 존재하지 않음");
		}
		
		
	}
	
}
