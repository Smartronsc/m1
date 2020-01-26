package com.androidcommand.app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
 
    private long id;
    private String name;
 
    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

	public String getName() {
		return this.name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return this.id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
}