package model;

import java.sql.Timestamp;

import javax.validation.constraints.Pattern;

public class Comment {
	
	@Pattern(regexp="^[0-9A-Za-z¹ê³ñœæŸ¿ó_-]{10,600}",message="must contain 10...600 chars")
	private String content;
	private Timestamp date;
	private String user_name;
	
	
	public Comment() {
	}
	
	public Comment(String content, Timestamp date, String user_name) {
		this.content = content;
		this.setDate();
		this.user_name = user_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Timestamp(System.currentTimeMillis());;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
