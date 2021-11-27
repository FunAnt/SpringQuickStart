package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL commands
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values "
								    	+ "((select nvl(max(seq),0)+1 from board),?,?,?)";	    								
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET    = "select * from board where seq = ?";		
	private final String BOARD_CNT    = "update board set cnt = cnt+1 where seq = ?";
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";	
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	// Article Registration
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC insertBoard()");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// Article Update
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC updateBoard()");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());		
	}
	
	// Article Delete
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC deleteBoard()");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	// Article Search
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC getBoard()");
		jdbcTemplate.update(BOARD_CNT, vo.getSeq());		
		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// Article List
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC getBoardList()");		
		Object args[] = {vo.getSearchKeyword()};
		
		if(vo.getSearchCondition().equals("TITLE")) {
			System.out.println("BOARD_LIST_T");
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			System.out.println("BOARD_LIST_C");
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		
		return null;		
	}
	
	class BoardRowMapper implements RowMapper<BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();		
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegDate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			
			return board;
		}
	}
	 
}
