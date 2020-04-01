package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JdbcDto;

@Repository
public class JdbcDaoImpl implements JdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<JdbcDto> selectList() {

		List<JdbcDto> list = new ArrayList<JdbcDto>();

		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";

		/*
		 * list = jdbcTemplate.query(sql, new RowMapper<JdbcDto>() {
		 * 
		 * @Override public JdbcDto mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * JdbcDto dto = new JdbcDto(); dto.setSEQ(rs.getInt(1));
		 * dto.setWRITER(rs.getString(2)); dto.setTITLE(rs.getString(3));
		 * dto.setCONTENT(rs.getString(4)); dto.setREGDATE(rs.getDate(5));
		 * 
		 * return dto; }
		 * 
		 * });
		 */
		
		// lambda로 바꿔보기 (java 1.8 이상부터)
		/*
		 * list = jdbcTemplate.query( sql, (rs, rowNum) -> { JdbcDto dto = new
		 * JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		 * rs.getDate(5)); return dto; } );
		 */
		
		// 클래스로 뺀 RowMapper를 객체로 가져다 쓰기
		list = jdbcTemplate.query(sql, new MyMapper());

		return list;
	}

	@Override
	public JdbcDto selectOne(int SEQ) {
		return null;
	}

	@Override
	public int insert(JdbcDto dto) {

		int res = 0;

		String sql = " INSERT INTO JDBCBOARD VALUES (JDBCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";

		res = jdbcTemplate.update(sql, new Object[] { dto.getWRITER(), dto.getTITLE(), dto.getCONTENT() });

		return res;
	}

	@Override
	public int update(JdbcDto dto) {
		return 0;
	}

	@Override
	public int delete(int SEQ) {
		return 0;
	}
	
	
	private static final class MyMapper implements RowMapper<JdbcDto> {

		@Override
		public JdbcDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
