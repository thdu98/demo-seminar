package com.application.model;

public class Singer {

	private Long IDSinger;

	private String NameSinger;

	public Singer() {

	}

	public Singer(Long iDSinger, String nameSinger) {
		super();
		IDSinger = iDSinger;
		NameSinger = nameSinger;
	}

	public Long getIDSinger() {
		return IDSinger;
	}

	public void setIDSinger(Long iDSinger) {
		IDSinger = iDSinger;
	}

	public String getNameSinger() {
		return NameSinger;
	}

	public void setNameSinger(String nameSinger) {
		NameSinger = nameSinger;
	}

	public void setNewSinger(Singer newSinger) {
		this.IDSinger = newSinger.IDSinger;
		this.NameSinger = newSinger.NameSinger;
	}

}
