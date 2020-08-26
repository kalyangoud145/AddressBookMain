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

	/* calls read method in the AddressBookImplementationto to open the addressbook 
	 * in the file*/
	@Override
	public void openAddressBook(String existingAddressBook)throws Exception {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.read(existingAddressBook);
	}

	/*Calls saveAddressBook method in AddressBookImplementation class with the name of file
	  in which data is to be saved*/
	public void saveAddressBook(String file) {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.saveAddressBook(file);
	}

	/*Calls saveAsAddressBook method in AddressBookImplementation class with the name of 
	 * file in which data is to be saved*/
	public void saveAsAddressBook() {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.saveAsAddressBook();
	}

	/*Calls closeAddressBook method in AddressBookImplementation class with the
	 *  name of file whose list is to be cleared if new address book is being opened*/
	public void closeAddressBook(String existingAddressBook) {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.closeAddressBook(existingAddressBook);
	}

	/* Close the entire address book*/
	@Override
	public void quit() {
		System.exit(0);
	}

	/*Checks total number of files present and displays the file names*/
	public void readAddress() {
		File f = new File("AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println("\n\t\t\t"+file.getName());
				count++;
			}
		}
		System.out.println("\n\t\t\tNumber of files: " + count);
		
	}

	/*Checks whether the file is present or not existingAddressBook is the name of file 
	 * to be checked return returns true if file is present or false if is not present*/
	public boolean checkAddress(String existingAddressBook) {
		File f = new File("AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(existingAddressBook + ".json")) {
					count++;
					break;
				}
			}
		}
		if (count == 1)
			return true;
		else
			return false;
	}	
	
}
