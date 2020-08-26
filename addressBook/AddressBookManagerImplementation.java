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
	
}
