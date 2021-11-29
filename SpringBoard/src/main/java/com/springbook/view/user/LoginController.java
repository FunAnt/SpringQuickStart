package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동...");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";						
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) throws Exception {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new Exception("아이디는 반드시 입력해야 합니다.");
		}
		
		UserVO user = userService.getUser(vo);
		
		System.out.println("로그인 인증 처리...");
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "redirect:getBoardList.do";
		}else{
			return "login.jsp";
		}				
	}
	
	@RequestMapping("/logout.do")
	public String login(HttpSession session) {
		session.invalidate();
		
		return "login.jsp";
	}
}
