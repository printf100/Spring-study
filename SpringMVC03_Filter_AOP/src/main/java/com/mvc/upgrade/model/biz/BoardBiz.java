package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.BoardDTO;

public interface BoardBiz {

	public List<BoardDTO> selectList();

	public BoardDTO selectOne(int myno);

	public int insert(BoardDTO dto);

	public int update(BoardDTO dto);

	public int delete(int myno);
}
