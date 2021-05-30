package paven;

import java.util.List;

public class Users {
	
	public Integer id;
	public String name;
	public String number;
	public String program;
	
	List<String> courses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	

	

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public String getUser() {
		
		return(this.id+" "+this.name+" "+this.number);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
