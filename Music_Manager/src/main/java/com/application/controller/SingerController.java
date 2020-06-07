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

import com.application.model.Singer;
import com.application.repository.SingerRepository;

@RestController
public class SingerController {
	@Autowired
	private SingerRepository singerRepository;

	@GetMapping("/singer")
	public List<Singer> findAllSinger() {
		return singerRepository.findAllSinger();
	}

	@GetMapping("/singer/{IDSinger}")
	public Singer findSingerByIDSinger(@PathVariable("IDSinger") Long IDSinger) {
		return singerRepository.findSingerByIDSinger(IDSinger);
	}
	@GetMapping("/singer/song/{IDSong}")
	public List<Singer> findSingerByIDSong(@PathVariable("IDSong") Long IDSong) {
		return singerRepository.findSingerByIDSong(IDSong);
	}

	@PostMapping("/singer")
	public void addSinger(@RequestBody Singer singer) {
		singerRepository.saveSinger(singer);
	}

	@PutMapping("/singer/{IDSinger}")
	public void editSong(@PathVariable("IDSinger") Long IDSinger, @RequestBody Singer newSinger) {
		Singer oldSinger = singerRepository.findSingerByIDSinger(IDSinger);
		oldSinger.setNewSinger(newSinger);
		singerRepository.updateSinger(oldSinger, IDSinger);
	}

	@DeleteMapping("/singer/{IDSinger}")
	public void deleteSinger(@PathVariable("IDSinger") Long IDSinger) {
		singerRepository.deleteSingerById(IDSinger);
	}

}
