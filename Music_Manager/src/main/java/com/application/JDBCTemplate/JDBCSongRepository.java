package com.application.JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.application.model.Song;
import com.application.repository.SongRepository;

//map query result to object song
class SongRowMapper implements RowMapper<Song> {

	@Override
	public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
		Song song = new Song();
		song.setIDSong(rs.getLong("id_song"));
		song.setNameSong(rs.getString("name_song"));
		song.setKindMusic(rs.getString("kind_music"));
		song.setComposeDate(rs.getDate("compose_date"));
		song.setPublishDate(rs.getDate("publish_date"));
		song.setMusicianID(rs.getLong("id_musician"));
		return song;
	}
}

@Repository
public class JDBCSongRepository implements SongRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Song> findAllSong() {
		String sql = "select * from song";
		List<Song> song = jdbcTemplate.query(sql, new SongRowMapper());
		return song;
	}

	@Override
	public void saveSong(Song song) {
		String sql = "insert into song (name_song, kind_music, publish_date, compose_date, id_musician) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, song.getNameSong(), song.getKindMusic(), song.getPublishDate(), song.getComposeDate(),
				song.getMusicianID());
	}

	@Override
	public void deleteSongByID(Integer IDSong) {
		String sql = "delete from song where id_song =?";
		jdbcTemplate.update(sql, IDSong);
	}

	@Override
	public Song findSongByIDSong(Long IDSong) {
		String sql = "select * from song where id_song = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { IDSong }, new SongRowMapper());
	}

	@Override
	public List<Song> findSongByIDMusician(Long IDMusician) {
		String sql = "select s.* from song s join musician m on s.id_musician = m.id_musician where m.id_musician = ?";
		return jdbcTemplate.query(sql, new Object[] { IDMusician }, new SongRowMapper());
	}

	@Override
	public List<Song> findSongByIDSinger(Long IDSinger) {
		String sql = "select s.* from song s " + "join sing si on (s.id_song = si.id_song) "
				+ "join singer sir on ( si.id_singer = sir.id_singer)" + " where sir.id_singer = ? ";
		return jdbcTemplate.query(sql, new Object[] { IDSinger }, new SongRowMapper());
	}

	@Override
	public void updateSong(Song song, Long IDSong) {
		String sql = "update song set name_song =?, kind_music =?, compose_date =?, publish_date =? where id_song =?";
		jdbcTemplate.update(sql, song.getNameSong(), song.getKindMusic(), song.getComposeDate(), song.getPublishDate(),song.getIDSong());

	}

}
