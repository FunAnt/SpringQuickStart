package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);		
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//1. Ŭ���̾�Ʈ�� ��û Path������ �����Ѵ�
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2. Ŭ���̾�Ʈ ��û path�� ���� �б�ó��
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			
			//1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. ȭ�� �׺���̼�
			if(user != null){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp"); 
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			HttpSession session = request.getSession(); 
			session.invalidate();
			
			response.sendRedirect("login.jsp");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			//1. ����� �Է� ���� ����
			request.setCharacterEncoding("EUC-KR");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			//2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			//3. ȭ�� �׺���̼�	
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			
			//1. ����� �Է� ���� ����
			//request.setCharacterEncoding("EUC-KR");
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");	
			String content = request.getParameter("content");
			
			//2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);	
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			//3. ȭ�� �׺���̼�	
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			//1. ����� �Է� ���� ����	
			String seq = request.getParameter("seq");	
			
			//2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
				
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			//3. ȭ�� �׺���̼�	
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ");
			
			//1. �˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");
			
			//2. DB ����ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//3.�˻� ����� ���ǿ� �����ϰ� ��� ȭ�� �̵�
			HttpSession session = request.getSession();
			session.setAttribute("board", board); 
			response.sendRedirect("getBoard.jsp");
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� ��ȸ");
			
			//1. ����� �Է� ���� ���� (TODO)
			//2. DB ����ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			//3.�˻� ����� ���ǿ� �����ϰ� ��� ȭ�� �̵�
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		} 
	}
}



