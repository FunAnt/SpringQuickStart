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
		System.out.println("�� ��� ��ȸ");
		
		//1. ����� �Է� ���� ���� (TODO)
		//2. DB ����ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//3.�˻� ����� ���ǿ� �����ϰ� ��� ȭ�� �̵�
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);	//Model ���� ����
		mav.setViewName("getBoardList");		//View ���� ����
				
		return mav;		
	}
}