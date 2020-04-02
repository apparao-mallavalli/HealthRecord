package model;

import java.time.LocalDate;

public class Hospital
{
  private String id;
  private String name;
  private String password;
  
  private String established;
  
  public Hospital(String id, String name, String password, String established) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.established = established;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
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


public String getEstablished() {
	return established;
}


public void setEstablished(String established) {
	this.established = established;
}


}
