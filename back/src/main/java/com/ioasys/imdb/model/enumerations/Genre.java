package com.ioasys.imdb.model.enumerations;

public enum Genre {
	ACAO_AVEMTURA("ação e aventura"),
	DRAMA("drama"),
	COMEDIA("comédia"),
	TERROR("terror"),
	FICCAO("ficção");
	
	private String description;
	
	private Genre (String description) {
		setDescription(description);
	}

	public String getdescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	
	}
}
