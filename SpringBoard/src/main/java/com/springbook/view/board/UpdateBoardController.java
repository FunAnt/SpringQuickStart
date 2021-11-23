package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 수정 처리");
		
		//1. 사용자 입력 정보 추출
		//request.setCharacterEncoding("EUC-KR");
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");	
		String content = request.getParameter("content");
		
		//2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);	
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		//3. 화면 네비게이션	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
}
