package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 ");
		
		//1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		
		//2. DB 연도처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3.검색 결과를 세션에 저장하고 목록 화면 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",board);		//Model 정보 저장
		mav.setViewName("getBoard");		//View 정보 저장
		
		return mav;
	}

}
