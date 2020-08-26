package addressBook;
/*Main class for the Address Book, where all the methods are called from this class*/
public class Main {
	public static void main(String[] args) throws Exception {
		InputScanner use = new InputScanner();
		AddressBookManagerImplementation addressBookManagerImpl = new AddressBookManagerImplementation();
		String existingAddressBook = "" ;
		int loop = 0;

		while (loop == 0) {
			AddressBookImplementation addressBookImpl = new AddressBookImplementation();
			System.out.println("\t\t\t________________________________________________\n"
					+ "\t\t\t|\t\t Address Book\t\t\t|\n"
					+ "\t\t\t|\t\t--------------\t\t\t|\n"
					+ "\t\t\t|\t1. Create new Address Book\t\t|\n"
					+ "\t\t\t|\t2. Open Address Book\t\t\t|\n"
					+ "\t\t\t|\t3. Save Address Book\t\t\t|\n"
					+ "\t\t\t|\t4. Save As Address Book\t\t\t|\n"
					+ "\t\t\t|\t5. Close Address Book\t\t\t|\n"  
					+ "\t\t\t|\t6. Quit Address Book\t\t\t|\n"
					+ "\t\t\t|_______________________________________________|\n");
			int choice = use.inputInteger();
			switch (choice) {
			case 1:
				addressBookManagerImpl.closeAddressBook(existingAddressBook);
				addressBookManagerImpl.newAddressBook();
				break;
			case 2:
				addressBookManagerImpl.closeAddressBook(existingAddressBook);
				addressBookManagerImpl.readAddress();
				System.out.println("\n\t\t\tEnter the name of the address book\n");
				existingAddressBook = use.inputString();
				if (addressBookManagerImpl.checkAddress(existingAddressBook)) {
					System.out.println("\t\t\tFile Exists\n");
					addressBookManagerImpl.openAddressBook(existingAddressBook);
					int i = 0;
					while (i == 0) {
						System.out.println("\t\t\t___________________\n"
								+ "\t\t\t|       Menu             |\n"
								+ "\t\t\t|      ------            |\n"
								+ "\t\t\t| 1. AddPerson           |\n"
								+ "\t\t\t| 2. EditPerson          |\n"
								+ "\t\t\t| 3. DeletePerson        |\n"
								+ "\t\t\t| 4. SearchPerson        |\n"
								+ "\t\t\t| 5. Sort By Name        |\n"
								+ "\t\t\t| 6. Sort By Zip         |\n"
								+ "\t\t\t| 7. Display all the list|\n"
								+ "\t\t\t| 8. Back to main menu   |\n"
								+ "\t\t\t|________________________|");
						int choose = use.inputInteger();
						switch (choose) {
						case 1:
							addressBookImpl.addPerson();
							break;
						case 2:
							addressBookImpl.editPerson();
							break;
						case 3:
							addressBookImpl.deletePerson();
							break;
						case 4:
							addressBookImpl.searchPerson();
							break;
						case 5:
							addressBookImpl.sortByName();
							break;
						case 6:
							addressBookImpl.sortByZip();
							break;
						case 7:
							addressBookImpl.display();
							break;
						case 8:
							System.out.println("\t\t\tRedirected to Main Menu");
							i = 1;
							break;
						default:
							System.out.println("\t\t\tWrong data recieved\n" + "\t\t\tAddress Book named '" + existingAddressBook
									+ "' closed\n");
							addressBookImpl.closeAddressBook(existingAddressBook);
							i = 1;
							break;
						}
					}
				} 
				else {
					System.out.println("\t\t\tEntered filename doesn't exist");
				}
				break;
			case 3:
				addressBookManagerImpl.saveAddressBook(existingAddressBook);
				break;
			case 4:
				addressBookManagerImpl.saveAsAddressBook();
				break;
			case 5:
				System.out.println("Closing the Address Book");
				addressBookManagerImpl.closeAddressBook(existingAddressBook);
				break;
			case 6:
				System.out.println("\t\t\tClosing the Address Book");
				addressBookManagerImpl.closeAddressBook(existingAddressBook);
				System.out.println("\t\t\t Quitting Address Book...!\n\t\t\t");
				addressBookManagerImpl.quit();
				loop = 1;
				break;
			default:
				System.out.println("\t\t\tSorry, Something went wrong....!\n" + "\t\t\tAddress Book is closed\n\t\t\t");
				loop = 1;
				break;
			}
		}
	}
}