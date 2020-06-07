package com.application.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.application.model.Musician;
import com.application.repository.MusicianRepository;

class MusicianRowMapper implements RowMapper<Musician> {

	@Override
	public Musician mapRow(ResultSet rs, int rowNum) throws SQLException {
		Musician musician = new Musician();
		musician.setIDMusicican(rs.getLong("id_musician"));
		musician.setNameMusician(rs.getString("name_musician"));
		return musician;
	}
}

@Repository
public class JDBCMusicianRepository implements MusicianRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Musician findMusicianBySongID(Long IDSong) {
		String sql = "select m.* from song s join musician m on s.id_musician = m.id_musician where s.id_song= ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { IDSong }, new MusicianRowMapper());
	}

	@Override
	public List<Musician> findAllMusician() {
		String sql = "select * from musician";
		return jdbcTemplate.query(sql, new MusicianRowMapper());
	}

	@Override
	public Musician findMusicianByIDMusician(Long IDMusician) {
		String sql = "select * from musician where id_musician = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { IDMusician }, new MusicianRowMapper());
	}

	@Override
	public void deleteMusician(Long IDMusician) {
		String sql = "delete from musician where id_musician = ?";
		jdbcTemplate.query(sql, new MusicianRowMapper());

	}

	@Override
	public void saveMusician(Musician musician) {
		String sql = "insert into musician (id_musician, name_musician) values (?,?)";
		jdbcTemplate.update(sql, musician.getIDMusicican(), musician.getNameMusician());

	}

	@Override
	public void updateMusician(Musician musician, Long IDMusician) {
		String sql = "update musician set name_musician = ? where id_musician = ?";
		jdbcTemplate.update(sql, musician.getNameMusician(), musician.getIDMusicican());
		
	}

}
