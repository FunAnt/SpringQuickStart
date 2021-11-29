package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// Article Registration
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard()");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	// Article Update
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard()");
		mybatis.update("BoardDAO.updateboard", vo);
	}
	
	// Article Delete
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard()");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	// Article Search
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard()");
		mybatis.update("BoardDAO.updateBoardCnt", vo);		
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard", vo);		
	}
	
	// Article List
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis getBoardList()");		
		return mybatis.selectList("BoardDAO.getBoardList", vo);				
	}	

}
