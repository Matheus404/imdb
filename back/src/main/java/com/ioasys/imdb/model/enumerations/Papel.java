package com.ioasys.imdb.model.enumerations;

public enum Papel {
	ROLE_ADMIN("ADMIN"),
	ROLE_USER("USER");
	
	private String description;
	
	private Papel(String description) {
		setDescription(description);
	}

	public String getdescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
