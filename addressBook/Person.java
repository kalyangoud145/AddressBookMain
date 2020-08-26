package addressBook;
/*pojoclass for Person */
public class Person {
	public String firstName;
	public String lastName;
	public String city;
	public String state;
	public long zip;
	public String phoneNumber;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZip(long zip) {
		this.zip = zip;
	}
	
	public long getZip() {
		return zip;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public String toString() {
		return "\n\t\t\tPerson \n\t\t\t\tFirst Name : " + firstName + "\n\t\t\t\tLast Name  : " + lastName + "\n\t\t\t\tCity:  " + city +"\n\t\t\t\tState  : " + state +"\n\t\t\t\tzip  : " + zip +"\n\t\t\t\tPhone Number : "
				+ phoneNumber + "\n\n";
	}

}
