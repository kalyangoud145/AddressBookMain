package addressBook;
import java.io.IOException;

/*Interface to implement functionalities like newAddressBook, openAddressBook,
 *  saveAddressBook , saveAsAddressBook, closeAddressBook and quit the addressbook*/
public interface AddressBookManagerInterface {
	public void newAddressBook() throws IOException;
	public void openAddressBook(String existingAddressBook)throws Exception;
	public void saveAddressBook(String file) ;
	public void saveAsAddressBook() ;
	public void closeAddressBook(String file) ;
	public void quit() ;
}
