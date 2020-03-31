package com.mvc.update.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.update.model.dao.JdbcDao;
import com.mvc.update.model.dto.JdbcDto;

@Service
public class JdbcBizImpl implements JdbcBiz {

	@Autowired
	private JdbcDao dao;

	@Override
	public List<JdbcDto> selectList() {
		return dao.selectList();
	}

	@Override
	public JdbcDto selectOne(int SEQ) {
		return null;
	}

	@Override
	public int insert(JdbcDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(JdbcDto dto) {
		return 0;
	}

	@Override
	public int delete(int SEQ) {
		return 0;
	}

}
