package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Musician;
import com.application.repository.MusicianRepository;

@RestController
public class MusicianController {
	@Autowired
	private MusicianRepository musicianRepository;

	@GetMapping("/musician")
	public List<Musician> findAllMusician() {
		return musicianRepository.findAllMusician();
	}

	@GetMapping("/musician/{IDMusician}")
	public Musician findMusicianByIDMusician(@PathVariable("IDMusician") Long IDMusician) {
		return musicianRepository.findMusicianByIDMusician(IDMusician);
	}
	@GetMapping("/musician/song/{IDSong}")
	public Musician findMusicianByIDSong(@PathVariable("IDSong") Long IDSong) {
		return musicianRepository.findMusicianBySongID(IDSong);
	}

	@PostMapping("/musician")
	public void addSong(@RequestBody Musician musician) {
		musicianRepository.saveMusician(musician);
	}

	@PutMapping("/musician/{IDMusician}")
	public void editMusician(@PathVariable("IDMusician") Long IDMusician, @RequestBody Musician newMusician) {
		Musician oldMusician = musicianRepository.findMusicianByIDMusician(IDMusician);
		oldMusician.setNewMusician(newMusician);
		musicianRepository.updateMusician(oldMusician, IDMusician);
	}

}
