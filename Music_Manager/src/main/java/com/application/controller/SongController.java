package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Song;
import com.application.repository.SongRepository;

@RestController
public class SongController {
	@Autowired
	private SongRepository songRepository;

	@GetMapping(value = "/song")
	public List<Song> findAllSong() {
		return songRepository.findAllSong();
	}

	@GetMapping(value = "/song/{IDSong}")
	public Song findSongByIDSong(@PathVariable("IDSong") Long IDSong) {
		return songRepository.findSongByIDSong(IDSong);
	}

	@GetMapping(value = "song/musician/{IDMusician}")
	public List<Song> findSongByIDMusician(@PathVariable("IDMusician") Long IDMusician) {
		return songRepository.findSongByIDMusician(IDMusician);
	}

	@GetMapping(value = "song/singer/{IDSinger}")
	public List<Song> findSongByIDSinger(@PathVariable("IDSinger") Long IDSinger) {
		return songRepository.findSongByIDSinger(IDSinger);
	}

	@PostMapping(value = "/song")
	public void addSong(@RequestBody Song song) {
		songRepository.saveSong(song);
	}

	@PutMapping(value = "/song/{IDSong}")
	public void editSong(@PathVariable("IDSong") Long IDSong, @RequestBody Song newSong) {
		Song oldSong = songRepository.findSongByIDSong(IDSong);
		oldSong.setNewSong(newSong);
		songRepository.updateSong(oldSong, IDSong);
	}

	@DeleteMapping(value = "/song/{IDSong}")
	public void deleteSong(@PathVariable("IDSong") Integer IDSong) {
		songRepository.deleteSongByID(IDSong);
	}
}
