package com.application.model;

import java.util.Date;

public class Song {
	private Long IDSong;

	private String NameSong;

	private String KindMusic;

	private Date publishDate;

	private Date composeDate;

	private Long IDMusician;

	public Song() {

	}

	public Song(Long iDSong, String nameSong, String kindMusic, Date publishDate, Date composeDate, Long IDMusician ) {
		super();
		this.IDSong = iDSong;
		this.NameSong = nameSong;
		this.KindMusic = kindMusic;
		this.publishDate = publishDate;
		this.composeDate = composeDate ;
		this.IDMusician = IDMusician;
	}

	public Long getIDSong() {
		return IDSong;
	}

	public void setIDSong(Long iDSong) {
		IDSong = iDSong;
	}

	public String getNameSong() {
		return NameSong;
	}

	public void setNameSong(String nameSong) {
		NameSong = nameSong;
	}

	public String getKindMusic() {
		return KindMusic;
	}

	public void setKindMusic(String kindMusic) {
		KindMusic = kindMusic;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getComposeDate() {
		return composeDate;
	}

	public void setComposeDate(Date composeDate) {
		this.composeDate = composeDate;
	}

	public Long getMusicianID() {
		return IDMusician;
	}

	public void setMusicianID(Long musicianID) {
		this.IDMusician = musicianID;
	}

	public void setNewSong(Song newSong) {
		this.IDSong = newSong.IDSong;
		this.NameSong = newSong.NameSong;
		this.IDMusician = newSong.IDMusician;
		this.KindMusic = newSong.KindMusic;
		this.publishDate = newSong.publishDate;
		this.publishDate = newSong.composeDate;

	}

}
