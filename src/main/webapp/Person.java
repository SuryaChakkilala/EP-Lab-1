package webapp;

public class Person {
	private int personId;
	private String firstName, lastName, address, city;
	
	public Person(int personId, String firstName, String lastName, String address, String city) {
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public int getPersonId() {
		return this.personId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String firstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() { 
		return this.city;
	}
	
	public String toString() {
		return "ID: " + this.personId + "\tFirst Name: " + this.firstName + "\tLast Name: " + this.lastName + "\tAddress: " + this.address + "\tCity: " + this.city;
	}
}
