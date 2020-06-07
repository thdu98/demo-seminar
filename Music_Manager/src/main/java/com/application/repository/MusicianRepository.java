package com.application.repository;

import java.util.List;

import com.application.model.Musician;

public interface MusicianRepository {
	public Musician findMusicianBySongID(Long iDSong);
	public List<Musician> findAllMusician();
	public Musician findMusicianByIDMusician(Long IDMusician);
	public void  deleteMusician(Long IDMusician);
	public void saveMusician(Musician musician);
	public void updateMusician(Musician musician, Long IDMusician);

}
