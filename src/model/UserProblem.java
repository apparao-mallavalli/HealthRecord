package model;

import java.time.LocalDate;

public class UserProblem
{
	private String id;
	private String message;
	private LocalDate date;
	
	public UserProblem(String id, String message, LocalDate date) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	

}
