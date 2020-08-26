
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

}
