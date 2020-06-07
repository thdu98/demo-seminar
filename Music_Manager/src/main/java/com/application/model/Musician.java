package com.application.model;

public class Musician {
	private Long IDMusicican;

	private String NameMusician;

	public Musician() {

	}

	public Musician(Long IDMusicican, String NameMusician) {
		this.NameMusician = NameMusician;
		this.IDMusicican = IDMusicican;
	}

	public Long getIDMusicican() {
		return IDMusicican;
	}

	public void setIDMusicican(Long iDMusicican) {
		IDMusicican = iDMusicican;
	}

	public String getNameMusician() {
		return NameMusician;
	}

	public void setNameMusician(String nameMusician) {
		NameMusician = nameMusician;
	}

	public void setNewMusician(Musician newMusician) {
		this.IDMusicican = newMusician.IDMusicican;
		this.NameMusician = newMusician.NameMusician;
	}

}
