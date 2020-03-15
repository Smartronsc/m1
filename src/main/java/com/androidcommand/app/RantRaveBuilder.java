package com.androidcommand.app;

public class RantRaveBuilder {
	
	private static RantRaveBuilder instance = new RantRaveBuilder();
	private String id = null;
	private String desctiption = "";
	
	private RantRaveBuilder() {}
	
	public static RantRaveBuilder create() { return instance; }
	
	public RantRaveBuilder withDescription(String description) {
		this.desctiption = description;
		return instance;
	}
	
	public RantRaveBuilder withId(String id) {
		this.id = id;
		return instance;
	}
	
	public RantRave build() {
		RantRave result = new RantRave(this.desctiption);
		if (id != null)
			result.setId(id);
		return result;
	}
	

}