package com.application.repository;

import java.util.List;

import com.application.model.Singer;

public interface SingerRepository {
	public List<Singer> findAllSinger();
	public Singer findSingerByIDSinger(Long IDSinger);
	public List<Singer> findSingerByIDSong(Long IDSong);
	public void saveSinger(Singer singer);
	public void deleteSingerById(Long IDSinger);
	public void updateSinger(Singer singer, Long IDSinger);

}
