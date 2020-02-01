package com.androidcommand.app;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
 
    private long id;
    private String name;
    private URL url;
 
    public Employee(long id, String name, URL url) {
        this.id = id;
        this.name = name;
        this.url = url;
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

	public URL getAddress() {
		return this.url;
	}
 
	public void setUrl(URL url) {
		this.url = url;
	}
}