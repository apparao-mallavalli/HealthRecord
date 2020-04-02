package model;

import java.time.LocalDate;

public class Patient 
{
   private String id;
   private String name;
   private String issueId;
   private LocalDate date;
   
   
public Patient(String id, String name, String issueId, LocalDate date) {
	super();
	this.id = id;
	this.name = name;
	this.issueId = issueId;
	this.date = date;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getIssueId() {
	return issueId;
}


public void setIssueId(String issueId) {
	this.issueId = issueId;
}


public LocalDate getDate() {
	return date;
}


public void setDate(LocalDate date) {
	this.date = date;
}


   
   
   
   
   
	
	
}
