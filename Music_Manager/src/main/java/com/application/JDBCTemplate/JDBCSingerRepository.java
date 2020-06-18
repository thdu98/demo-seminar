package com.application.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.application.model.Singer;
import com.application.repository.SingerRepository;

class SingerRowMapper implements RowMapper<Singer> {

	@Override
	public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Singer singer = new Singer();
		singer.setIDSinger(rs.getLong("id_singer"));
		singer.setNameSinger(rs.getString("name_singer"));
		return singer;
	}
}

@Repository
public class JDBCSingerRepository implements SingerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Singer> findAllSinger() {
		String sql = "select * from singer";
		List<Singer> singer = jdbcTemplate.query(sql, new SingerRowMapper());
		return singer;
	}

	@Override
	public Singer findSingerByIDSinger(Long IDSinger) {
		String sql = "select * from singer where id_singer = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {IDSinger}, new SingerRowMapper());
	}

	@Override
	public List<Singer> findSingerByIDSong(Long IDSong) {
		String sql = "select sir.* from singer sir join sing si on sir.id_singer = si.id_singer join song s on s.id_song = si.id_song where si.id_song = ?";
		return jdbcTemplate.query(sql, new Object[] { IDSong }, new SingerRowMapper());
	}

	@Override
	public void saveSinger(Singer singer) {
		String sql = "insert into singer (id_singer, name_singer) values (?,?)";
		jdbcTemplate.update(sql, singer.getIDSinger(), singer.getNameSinger());
	}

	@Override
	public void deleteSingerById(Long IDSinger) {
		String sql = "delete from singer where id_singer = ?";
		jdbcTemplate.update(sql, IDSinger);
	}

	@Override
	public void updateSinger(Singer singer, Long IDSinger) {
		String sql = "update singer set name_singer = ? where id_singer = ?";
		jdbcTemplate.update(sql,singer.getNameSinger(), singer.getIDSinger());
		
	}
	

}
