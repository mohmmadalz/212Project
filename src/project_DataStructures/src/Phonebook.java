import java.util.Scanner;
public class Phonebook{
	private LinkedList<Contact> contacts;
	private LinkedList<Event> Events ;


	public Phonebook() {
		contacts = new LinkedList<>();
		Events = new LinkedList<>();

	}


	public void addContact(Contact contact) {
		if(contacts.empty()) {
			contacts.insert(new Contact("","","","","", ""));
			contacts.insert(contact);
			return;
		}
		contacts.findFirst();
		Contact prev=contacts.retrieve();
		while(!contacts.last()) {
			if(contacts.retrieve().compareTo(contact)>0) {
				contacts.find(prev);
				contacts.insert(contact);
				return;
			}
			prev=contacts.retrieve();
			contacts.findNext();
		}
		if(contacts.retrieve().compareTo(contact)>0) {
			contacts.find(prev);
			contacts.insert(contact);
			return;
		}
		else {
			contacts.insert(contact);
			return;
		}
	}

	public void searchContact(int criteria) {
		String searchValue="";
		LinkedList<Contact> founded;
		Scanner input = new Scanner(System.in);
		contacts.findFirst();

		switch (criteria) {

		case 1:
			System.out.print("\nEnter the contact's name:");
			searchValue=input.nextLine();
			Contact contactByName=searchByName(searchValue);
			if(contactByName != null)
				contactByName.printInfo();
			else
				System.out.println("\ncontact not found");
			break;

		case 2:
			System.out.print("\nEnter the contact's PhoneNumber:");
			searchValue=input.next();
			Contact contactByPhoneNumber=searchByPhoneNumber(searchValue);
			if(contactByPhoneNumber != null)
				contactByPhoneNumber.printInfo();
			else
				System.out.println("\ncontact not found");
			break;

		case 3:
			System.out.print("\nEnter the contact's EmailAddress: ");
			searchValue=input.next();
			founded=searchByEmailAddress(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("\ncontact not found");
			break;

		case 4:
			System.out.print("\nEnter the contact's Address:");
			searchValue=input.nextLine();
			founded=searchByAddress(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("\ncontact not found");
			break;

		case 5:
			System.out.print("\nEnter the contact's Birthday:");
			searchValue=input.next();
			founded=searchByBirthday(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("\ncontact not found");
			break;
		default:
			System.out.println("\nInvalid criteria");
			break;
		}

	}


	public void deleteContact(String name) {
		if (contacts.empty()) {
			System.out.print("\nPhonebook is empty.");
			return;
		}
		if(searchByName(name)==null) {
			System.out.print("\nContact not found.");
			return;
		}
		contacts.findFirst();
		while (!contacts.last()) {
			if (contacts.retrieve().getName().equalsIgnoreCase(name)) {
				deleteContactEvents(name);
				contacts.remove();											// contact removed successfully
				System.out.print("\nContact deleted successfully.");
				return;
			}
			contacts.findNext();
		}
		//This is for the last element
		if (contacts.retrieve().getName().equalsIgnoreCase(name)) {
			deleteContactEvents(name);
			contacts.remove();
			System.out.print("\nContact deleted successfully.");
			return;
		}

	}

	public void printContactsByFirstName(String firstName) {

		LinkedList<Contact> founded = new LinkedList<>();
		if(contacts.empty())
			System.out.println("\nthere are no contacts by this first name ");
		contacts.findFirst();
		firstName += " "; //
		while(!contacts.last()) {
			if(contacts.retrieve().getName().startsWith(firstName))
				founded.insert(contacts.retrieve());
			contacts.findNext();
		}
		if(contacts.retrieve().getName().startsWith(firstName))
			founded.insert(contacts.retrieve());
		printAllContacts(founded);
	}

	// -- helper methods for contact --

	private void printAllContacts(LinkedList<Contact> list) {
		if(list.empty())
			return;
		list.findFirst();
		if(list.last())
			System.out.print("\nContact found!\r");
		else
			System.out.print("\nContacts found!\r");
		while(!list.last()) {
			list.retrieve().printInfo();
			list.findNext();
		}
		list.retrieve().printInfo();
	}


	private Contact searchByName(String name) {
		if(contacts.empty())
			return null;
		contacts.findFirst();
		while(!contacts.last()) {
			if(contacts.retrieve().getName().equalsIgnoreCase(name))
				return contacts.retrieve();
			contacts.findNext();
		}
		if(contacts.retrieve().getName().equalsIgnoreCase(name))
			return contacts.retrieve();
		return null;
	}

	private Contact searchByPhoneNumber(String PhoneNumber) {
		if(contacts.empty())
			return null;
		contacts.findFirst();
		while(!contacts.last()) {
			if(contacts.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
				return contacts.retrieve();
			contacts.findNext();
		}
		if(contacts.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
			return contacts.retrieve();
		return null;
	}

	private LinkedList<Contact> searchByEmailAddress(String EmailAddress) {
		LinkedList<Contact> founded = new LinkedList<>();
		if(contacts.empty())
			return founded;
		contacts.findFirst();
		while(!contacts.last()) {
			if(contacts.retrieve().getEmailAddress().equalsIgnoreCase(EmailAddress))
				founded.insert(contacts.retrieve());
			contacts.findNext();
		}
		if(contacts.retrieve().getEmailAddress().equalsIgnoreCase(EmailAddress))
			founded.insert(contacts.retrieve());
		return founded;
	}

	private LinkedList<Contact> searchByAddress(String Address) {
		LinkedList<Contact> founded = new LinkedList<>();
		if(contacts.empty())
			return founded;
		contacts.findFirst();
		while(!contacts.last()) {
			if(contacts.retrieve().getAddress().equalsIgnoreCase(Address))
				founded.insert(contacts.retrieve());
			contacts.findNext();
		}
		if(contacts.retrieve().getAddress().equalsIgnoreCase(Address))
			founded.insert(contacts.retrieve());
		return founded;
	}

	private LinkedList<Contact> searchByBirthday(String Birthday) {
		LinkedList<Contact> founded = new LinkedList<>();
		if(contacts.empty())
			return founded;
		contacts.findFirst();
		while(!contacts.last()) {
			if(contacts.retrieve().getBirthday().equalsIgnoreCase(Birthday))
				founded.insert(contacts.retrieve());
			contacts.findNext();
		}
		if(contacts.retrieve().getBirthday().equalsIgnoreCase(Birthday))
			founded.insert(contacts.retrieve());
		return founded;
	}
	private boolean contactExists(Contact contact) {
		return (searchByName(contact.getName()) !=null || searchByPhoneNumber(contact.getPhoneNumber()) !=null);
	}

	private void deleteContactEvents (String name) {
		if(Events.empty())
			return;
		Events.findFirst();
		Events.findNext();
		while(!Events.last()) {
			if( Events.retrieve().getEventuser().getName().equalsIgnoreCase(name) ) {
				Events.remove();
				continue;
			}
			Events.findNext();
		}
		if( Events.retrieve().getEventuser().getName().equalsIgnoreCase(name) ) 
			Events.remove();
	}


	// -- event method --

	public void scheduleEvent() {
		// 1- contact exist
		// 2- no conflict

		Scanner input = new Scanner(System.in);
		Event tmp = new Event();
		System.out.print("\nEnter event title:");
		tmp.setTitle(input.nextLine());
		System.out.print("Enter contact name:");
		tmp.setEventuser(searchByName(input.nextLine()));
		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
		tmp.setDate(input.nextLine());
		System.out.print("Enter event location:");
		tmp.setLocation(input.nextLine());

		if( (tmp.getEventuser()!= null) && !eventConflictExists(tmp.getDate())) {
			addEvent(tmp);
		}
		else {
			System.out.println("\nEvent Scheduling failed ");
		}
	}

	private void addEvent(Event tmp) {
		Event nullEvent = new Event("", "", "", null);
		if(Events.empty()) {
			Events.insert(nullEvent);
			Events.insert(tmp);
			System.out.println("\nEvent scheduled successfully!");
			return;
		}
		Events.findFirst();
		Event prev=Events.retrieve();
		while(!Events.last()) {
			if(Events.retrieve().compareTo(tmp)>0) {
				Events.find(prev);
				Events.insert(tmp);
				System.out.println("\nEvent scheduled successfully!");
				return;
			}
			prev=Events.retrieve();
			Events.findNext();
		}
		if(Events.retrieve().compareTo(tmp)>0) {
			Events.find(prev);
			Events.insert(tmp);
			System.out.println("\nEvent scheduled successfully!");
			return;
		}
		else {
			Events.insert(tmp);
			System.out.println("\nEvent scheduled successfully!");
		}
	}


	public void PrintEventDetails(int criteria) {
		//by contact name pos1
		//by event title  

		Scanner input = new Scanner(System.in);
		if(Events.empty()) {
			System.out.println("\nEvent not found!");
			return ;
		}
		Events.findFirst();
		Events.findNext();
		String result="";
		switch (criteria) {
		case 1: {
			System.out.print("Enter the contact's name:");
			String contactName= input.nextLine();
			System.out.println();
			while(!Events.last()) {
				if(Events.retrieve().getEventuser().getName().equalsIgnoreCase(contactName)) {
					result+=Events.retrieve().Info();
				}
				Events.findNext();
			}
			if(Events.retrieve().getEventuser().getName().equalsIgnoreCase(contactName)) {
				result+=Events.retrieve().Info();
			}
			if(result!="") {
				System.out.print("\nEvent found!");
				System.out.println(result);
			}
			break;
		}
		case 2: {
			System.out.print("Enter the event title:");
			String eventTitle= input.nextLine();
			while(!Events.last()) {
				if(Events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
					result+=Events.retrieve().Info();
				}
				Events.findNext();
			}
			if(Events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
				result+=Events.retrieve().Info();
			}
			if(result!="") {
				System.out.print("\nEvent found!");
				System.out.println(result);
			}
			break;
		}
		default:
			System.out.println("\ninvalid input");
		}
	}

	public void printAllEventsAlphabetically() {

		if(Events.empty())
			return;
		String result="";
		Events.findFirst();
		Events.findNext();
		while(!Events.last()) {
			result+=Events.retrieve().Info();
			Events.findNext();
		}
		result+=Events.retrieve().Info();
		System.out.println(result);
	}


	// -- helper methods for event --

	private boolean eventConflictExists(String date) {
		if(Events.empty()) {
			return false ;             // empty 
		}
		Events.findFirst();
		Events.findNext();
		while(!Events.last()) {
			if( Events.retrieve().getDate().equalsIgnoreCase(date) )  // list without the last 
				return true ;
			Events.findNext();
		} 
		if( Events.retrieve().getDate().equalsIgnoreCase(date) )  // list element in Event 
			return true ;
		return false ;
	}


	// main

	public void menu() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			String menu="\nWelcome to the Linked Tree Phonebook!\r\n"
					+ "Please choose an option:\r\n"
					+ "1. Add a contact\r\n"
					+ "2. Search for a contact\r\n"
					+ "3. Delete a contact\r\n"
					+ "4. Schedule an event\r\n"
					+ "5. Print event details\r\n"
					+ "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n"
					+ "8. Exit\r\n"
					+ "\nEnter your choice:";
			System.out.print(menu);
			try {
				choice= input.nextInt();
				input.nextLine();
			}
			catch (Exception e) {
				choice=9;
				input.next();
			}
			switch (choice) {
			case 1: {
				Contact contact = new Contact();
				System.out.print("\nEnter the contact's name:");
				contact.setName(input.nextLine());
				System.out.print("Enter the contact's phone number:");
				contact.setPhoneNumber(input.next());
				System.out.print("Enter the contact's email address:");
				contact.setEmailAddress(input.next());
				System.out.print("Enter the contact's address:");
				contact.setAddress(input.nextLine());
				contact.setAddress(input.nextLine());
				System.out.print("Enter the contact's birthday:");
				contact.setBirthday(input.next());
				input.nextLine();
				System.out.print("Enter any notes for the contact:");
				contact.setNotes(input.nextLine());
				if(!contactExists(contact)) {
					System.out.println("\nContact added successfully!");
					addContact(contact);
				}

				break;
			}
			case 2: {
				System.out.print("\nEnter search criteria:\r\n"
						+ "1. Name\r\n"
						+ "2. Phone Number\r\n"
						+ "3. Email Address\r\n"
						+ "4. Address\r\n"
						+ "5. Birthday\r\n"
						+ "\nEnter your choice:");
				try {
					int criteria=input.nextInt();
					searchContact(criteria);
				} catch (Exception e) {
					System.out.println("\ninvalid input!\n");
					choice=9;
					input.next();
					break;
				}

			}
			break;
			case 3: {
				System.out.print("Enter the contact's name:");
				deleteContact(input.nextLine());
				break;
			}
			case 4: {
				scheduleEvent();
				break;
			}
			case 5: {
				System.out.print("Enter search criteria:\r\n"
						+ "1. contact name\r\n"
						+ "2. Event tittle\r\n"
						+ "Enter your choice:");
				try{
					int criteria=input.nextInt();
					PrintEventDetails(criteria);
					break;
				}
				catch (Exception e2) {
					System.out.println("\ninvalid input!\n");
					choice=9;
					input.next();
					break;
				}
			}
			case 6: {
				System.out.print("Enter the first name:");
				printContactsByFirstName(input.nextLine());
				break;
			}
			case 7: {
				printAllEventsAlphabetically();
				break;
			}
			case 8: {
				System.out.print("Goodbye!");
				break;
			}
			default:
				System.out.println("\ninvalid input! try again \n");;
				break;
			}
		} while(choice != 8);

		input.close();
	}

}
