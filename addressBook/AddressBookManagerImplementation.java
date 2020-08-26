package addressBook;
import java.io.IOException;
import java.io.File;

/*Class contains methods implemented by addressBookManagerInterface methods*/
public  class AddressBookManagerImplementation implements AddressBookManagerInterface{

	 /*Creates a new file in the address book*/
	public void newAddressBook() throws IOException {
		InputScanner use = new InputScanner();
		System.out.println("\n\t\t\tEnter the name of address book");
		String NewAddressBookName = use.inputString();
		File file = new File("AddressBookFolder//" + NewAddressBookName + ".json");
		if (file.createNewFile()) {
			System.out.println("\n\t\t\tFile is created!");
		} else {
			System.out.println("\n\t\t\tFile already exists.");
		}
		
	}	
	
}
