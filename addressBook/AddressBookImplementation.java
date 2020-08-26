
package addressBook;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.io.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/*Class contains methods implemented by addressBookInterface methods*/
public class AddressBookImplementation implements AddressBookInterface{

	InputScanner use = new InputScanner();
	public static List<Person> list = new ArrayList<Person>();
	ObjectMapper mapper = new ObjectMapper();

	/*add person to the  person list*/
	public  List<Person> addPerson() {
		list.add(addUser());
		for (Person P : list) {
			System.out.println(P.toString());
		}
		return list;
	}
	
	/*Adding information of person and add it in an object
	 * return object of person will give with added information in it
	 */
	private Person addUser() {
		Person person = new Person();
		System.out.println("\n\t\t\tEnter First Name");
		person.setFirstName(use.inputString());
		System.out.println(person.getFirstName());
		System.out.println("\n\t\t\tEnter Last Name");
		person.setLastName(use.inputString());
		System.out.println("\n\t\t\tEnter city");
		person.setCity(use.inputString());
		System.out.println("\n\t\t\tEnter State");
		person.setState(use.inputString());
		System.out.println("\n\t\t\tEnter ZipCode");
		person.setZip(use.inputInteger());
		System.out.println("\n\t\t\tEnter Phone Number");
		person.setPhoneNumber(use.inputString());
		return person;
	}

	/*Editing information of existing Person from list */
	static int count = 0;
	public void editPerson() {
		System.out.println("\n\t\t\tEnter phone Number of the Peson whose details you want to edit");
		String phoneNumber = use.inputString();
		for (Person P : list) {
			if (phoneNumber.equals(P.getPhoneNumber())) {
				count++;
				System.out.println("\n\t\t\tData found\n");
				System.out.println("\t\t\t1.To edit Firstname and lastname\n\t\t\t2.To edit city,State and zip\n" +"\t\t\t3. To edit Phone Number\n");
				int editChoice = use.inputInteger();
				switch (editChoice) {
				case 1:
					editAddressBookPerson(P, 1);
					break;
				case 2:
					editAddressBookPerson(P, 2);
					break;
				case 3:
					editAddressBookPerson(P, 3);
					break;
				default:
					System.out.println("\t\t\tSomething went wrong\n" + "\t\t\tTry again later");
				}
			} 
		} 
		if(count==0)
			System.out.println("\n\t\t\tData not found");	
	}

	/*Editing of Firstname, lastname, state, city, zip  and phone number
	 *  P is the person object
	 *  i is the case for editing address or phone number*/
	private void editAddressBookPerson(Person P, int i) {
		switch (i) {
		case 1:
			System.out.println("\n\t\t\tEnter the FirstName");
			P.setFirstName(use.inputString());
			System.out.println("\n\t\t\tEnter the LastName");
			P.setLastName(use.inputString());
			System.out.println("\n\t\t\tNew Firstname and Lastname are updated");
			break;
		case 2:
			System.out.println("\n\t\t\tEnter the state");
			P.setState(use.inputString());
			System.out.println("\n\t\t\tEnter the city");
			P.setCity(use.inputString());
			System.out.println("\n\t\t\tEnter the ZipCode");
			P.setZip(use.inputInteger());
			System.out.println("\n\t\t\tNew city,State and zip are updated");
			break;
		case 3:
			System.out.println("\n\t\t\tEnter the new Phone Number");
			String phoneNumber = use.inputString();
			P.setPhoneNumber(phoneNumber);
			System.out.println("\n\t\t\tNew Phone Number updated ");
			break;
		}
	}

	/*To search if the person is present or not, using phoneNumber of the person as search parameter*/
	public void searchPerson() {
		System.out.println("\n\t\t\tEnter the phoneNumber of the person to be searched");
		String phoneNumber = use.inputString();
		int count = 0;
		List<Person> toSearch = new ArrayList<>();
		for (Person P : list) {
			if (phoneNumber.equals(P.getPhoneNumber())) {
				System.out.println("\n\t\t\tPerson found");
				toSearch.add(P);
				count++;
				System.out.println(toSearch);
			}
		}
		
		if (count == 0)
			System.out.println("\n\t\t\tSorry, no such person is  found in the address book");
	}	

	/*Sorting of list respect to zip*/
	public void sortByZip() {
		Collections.sort(list, new SortByZip());
		for (Person person : list) {
			System.out.println(person.toString());
		}	
	}

	public class SortByZip implements Comparator<Person> {
	/* 
	 * Compares the data and returns 0 if the  data is same 
	 * and 1 if first data is greater
	 * and -1 if second data is greater
	 */
	@Override
		public int compare(Person p1, Person p2) {
			if(p1.getZip()==p2.getZip())
				return 0;
			else {
				if(p1.getZip()>p2.getZip()) {
					return 1;
				}else {
					return -1;
				}
			}
		}
	}

	/*Sorting of list respect to First Name*/
	public void sortByName() {
		Collections.sort(list, new SortByName());
		for (Person person : list) {
			System.out.println(person.toString());
		}	
	}

	public class SortByName implements Comparator<Person>{
	/* 
	 * Compares the data and returns 0 if the  data is same 
	 * and 1 if first data is greater
	 * and -1 if second data is greater
	 */
		public int compare(Person personOne, Person personTwo) {
			if(personOne.getFirstName().equals(personTwo.getFirstName()))
				return 0;
			else {
				if(personOne.getFirstName().compareTo(personTwo.getFirstName())>0) {
					return 1;
					}
				else {
					return -1;
					}
				}
			}
	}

	/*Displaying the list*/
	public void display() {
		for (Person P : list) {
			System.out.println(P.toString());
		}
	}

	/*Saving list data in file */
	public void saveAddressBook(String file) {
		try {
			mapper.writeValue(new File("AddressBook/" + file + ".json"), list);
			System.out.println("\n\t\t\tSaved");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
