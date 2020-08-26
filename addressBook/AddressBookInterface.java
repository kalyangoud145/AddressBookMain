package addressBook;
import java.util.*;

/*Interface to add functionalities to add, edit, delete, sort by name, 
sort by zip and display with respect to Person*/
public interface AddressBookInterface {
	public List<Person> addPerson() ;
	public void editPerson() ;
	public void deletePerson() throws  Exception;
	public void searchPerson() ;
	public void sortByZip() ;
	public void sortByName() ;
	public void display() ;
}