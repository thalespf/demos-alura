package com.thalespf.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exam implements Serializable {
	
	private String date;
	
	private String matter;
	
	private String description;
	
	private List<String> topics = new ArrayList<String>();

	public Exam(String date, String matter) {
		this.date = date;
		this.matter = matter;
	}
	
	@Override
	public String toString() {
		return matter + " - " + date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

}