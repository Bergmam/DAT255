package se.chalmers.dat255.risk.net;

public class User {

	private String username;
	
	public User(String name){
		username = name;
	}
	public void setUsername(String s){
		username = s;
	}
	
	public String getUsername(){
		return username;
	}
}
