package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDTO;

public interface BoardDAO {

	String NAMESPACE = "myboard.";

	public List<BoardDTO> selectList();

	public BoardDTO selectOne(int myno);

	public int insert(BoardDTO dto);

	public int update(BoardDTO dto);

	public int delete(int myno);

	public String test();
}
