package edu.eci.cvds.servlet.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Todo {
	
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public Todo(int userId, int id, String title, boolean completed) {
		this.userId = userId;
		this.id=id;
		this.title = title;
		this.completed = completed;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public int getUserId() {
		
		return userId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean getCompleted() {
		return completed;
	}

}
