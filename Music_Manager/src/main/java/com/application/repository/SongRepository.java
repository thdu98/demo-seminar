package com.application.repository;

import java.util.List;


import com.application.model.Song;

public interface SongRepository {
	public List<Song> findAllSong();
	public Song findSongByIDSong(Long IDSong);
	public List<Song> findSongByIDMusician(Long IDMusician);
	public List<Song> findSongByIDSinger(Long IDSinger);
	public void saveSong(Song song);
	public void deleteSongByID(Integer id);
	public void updateSong(Song song, Long IDSong);

}
