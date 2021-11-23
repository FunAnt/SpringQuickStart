package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 조회");
		
		//1. 사용자 입력 정보 추출 (TODO)
		//2. DB 연동처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//3.검색 결과를 세션에 저장하고 목록 화면 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);	//Model 정보 저장
		mav.setViewName("getBoardList");		//View 정보 저장
				
		return mav;		
	}
}
