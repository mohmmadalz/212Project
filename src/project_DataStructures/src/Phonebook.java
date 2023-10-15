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
			System.out.println("Enter the contact's name: ");
			searchValue=input.nextLine();
			Contact contactByName=searchByName(searchValue);
			input.close();
			if(contactByName != null)
				contactByName.printInfo();
			else
				System.out.println("contact not found");
			break;

		case 2:
			System.out.println("Enter the contact's PhoneNumber: ");
			searchValue=input.next();
			input.close();
			Contact contactByPhoneNumber=searchByPhoneNumber(searchValue);
			if(contactByPhoneNumber != null)
				contactByPhoneNumber.printInfo();
			else
				System.out.println("contact not found");
			break;

		case 3:
			System.out.println("Enter the contact's EmailAddress: ");
			searchValue=input.next();
			input.close();
			founded=searchByEmailAddress(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("contact not found");
			break;

		case 4:
			System.out.println("Enter the contact's Address: ");
			searchValue=input.nextLine();
			input.close();
			founded=searchByAddress(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("contact not found");
			break;

		case 5:
			System.out.println("Enter the contact's Birthday: ");
			searchValue=input.next();
			input.close();
			founded=searchByBirthday(searchValue);
			if(!founded.empty())
				printAllContacts(founded);
			else
				System.out.println("contact not found");
			break;
		default:
			System.out.println("Invalid criteria");
			input.close();
			break;
		}

	}


	public void deleteContact(String name) {
		if (contacts.empty()) {
			System.out.println("Phonebook is empty.");
			return;
		}
		if(searchByName(name)==null) {
			System.out.println("Contact not found.");
			return;
		}
		contacts.findFirst();
		while (!contacts.last()) {
			if (contacts.retrieve().getName().equalsIgnoreCase(name)) {
				contacts.remove();											// contact removed successfully
				deleteContactEvents(name);
				System.out.println("Contact deleted successfully.");
				return;
			}
			contacts.findNext();
		}
		//This is for the last element
		if (contacts.retrieve().getName().equalsIgnoreCase(name)) {
			contacts.remove();
			deleteContactEvents(name);
			System.out.println("Contact deleted successfully.");
			return;
		}
		
	}

	public void printContactsByFirstName(String firstName) {

		LinkedList<Contact> founded = new LinkedList<>();
		if(contacts.empty())
			System.out.println("there are no contacts by this first name ");
		contacts.findFirst();
		firstName += " ";
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
			System.out.println("Contact found!\r\n");
		else
			System.out.println("Contacts found! \r\n");
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
		return (searchByName(contact.getName()) !=null && searchByPhoneNumber(contact.getPhoneNumber()) !=null);
	}

	private void deleteContactEvents (String name) {
		if(Events.empty())
			return;
		Events.findFirst();
		while(!Events.last()) {
			if( Events.retrieve().getEventuser().getName().equalsIgnoreCase(name) ) 
				Events.remove();	
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
		System.out.println("Enter event title:");
		tmp.setTitle(input.nextLine());
		System.out.println("Enter contact name: ");
		tmp.setEventuser(searchByName(input.nextLine()));
		System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
		tmp.setDate(input.nextLine());
		System.out.println("Enter event location:");
		tmp.setLocation(input.nextLine());

		if( (tmp.getEventuser()!= null) && !eventConflictExists(tmp.getDate())) {
			addEvent(tmp);
		}
		else {
			System.out.println("Event Scheduling failed ");
		}
		input.close();
	}
	
	private void addEvent(Event tmp) {
		if(Events.empty()) {
			Events.insert(tmp);
			return;
		}
		Events.findFirst();
		Event prev=Events.retrieve();
		while(!Events.last()) {
			if(Events.retrieve().compareTo(tmp)>0) {
				Events.find(prev);
				Events.insert(tmp);
				System.out.println("Event scheduled successfully!");
				return;
			}
		prev=Events.retrieve();
			Events.findNext();
		}
		if(Events.retrieve().compareTo(tmp)>0) {
			Events.find(prev);
			Events.insert(tmp);
			System.out.println("Event scheduled successfully!");
			return;
		}
		else {
			Events.insert(tmp);
			System.out.println("Event scheduled successfully!");
		}
	}
	
		
	public void PrintEventDetails(int criteria) {
		//by contact name pos1
		//by event title  
		Scanner input = new Scanner(System.in);
		if(Events.empty()) {
			System.out.println("Event not found!");
			input.close();
			return ;
		}
		switch (criteria) {
		case 1: {
			System.out.println("Enter the contact's name: ");
			String contactName= input.nextLine();
			
			System.out.println();
			while(!Events.last()) {
				if(Events.retrieve().getEventuser().getName().equalsIgnoreCase(contactName)) {
					Events.retrieve().printInfo();
				}
			}
			if(Events.retrieve().getEventuser().getName().equalsIgnoreCase(contactName)) {
				Events.retrieve().printInfo();
			}
			break;
		}
		case 2: {
			System.out.println("Enter the event title: ");
			String eventTitle= input.nextLine();
			while(!Events.last()) {
				if(Events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
					Events.retrieve().printInfo();
				}
			}
			if(Events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
				Events.retrieve().printInfo();
			}
			break;
		}
		default:
			System.out.println("invalid input");
		}
		input.close();
	}

	public void printAllEventsAlphabetically() {
		
		if(Events.empty())
			return;
		Events.findFirst();
		while(!Events.last()) {
			Events.retrieve().printInfo();
			Events.findNext();
		}
		Events.retrieve().printInfo();
	}


	// -- helper methods for event --

	private boolean eventConflictExists(String date) {
		if(Events.empty()) {
			return false ;             // empty 
		}
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
		int choice;
		do {
			String menu="Welcome to the Linked Tree Phonebook!\r\n"
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
			System.out.println(menu);
			choice= input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1: {
				Contact contact = new Contact();
				System.out.println("\nEnter the contact's name: ");
				contact.setName(input.nextLine());
				System.out.println("\nEnter the contact's phone number: ");
				contact.setPhoneNumber(input.next());
				System.out.println("Enter the contact's email address: ");
				contact.setEmailAddress(input.next());
				contact.setName(input.nextLine());
				System.out.println("Enter the contact's address: ");
				contact.setAddress(input.nextLine());
				System.out.println("Enter the contact's birthday: ");
				contact.setBirthday(input.next());
				System.out.println("Enter any notes for the contact: ");
				contact.setNotes(input.nextLine());
				if(!contactExists(contact)) {
					System.out.println("\nContact added successfully!\n");
					addContact(contact);
				}

				break;
			}
			case 2: {
				System.out.println("Enter search criteria:\r\n"
						+ "1. Name\r\n"
						+ "2. Phone Number\r\n"
						+ "3. Email Address\r\n"
						+ "4. Address\r\n"
						+ "5. Birthday\r\n"
						+ "\nEnter your choice: ");
				int criteria=input.nextInt();
				searchContact(criteria);
			}
			break;
			case 3: {
				System.out.println("Enter the contact's name:");
				deleteContact(input.nextLine());
				break;
			}
			case 4: {
				scheduleEvent();
				break;
			}
			case 5: {
				System.out.println("Enter search criteria:\r\n"
						+ "1. contact name\r\n"
						+ "2. Event tittle\r\n"
						+ "Enter your choice:");
				int criteria=input.nextInt();
				PrintEventDetails(criteria);
				break;
			}
			case 6: {
				System.out.println("Enter the first name: ");
				printContactsByFirstName(input.nextLine());
				break;
			}
			case 7: {
				printAllEventsAlphabetically();
				break;
			}
			case 8: {
				System.out.println("Goodbye!");
				break;
			}
			default:
				System.out.println("invalid input!");;
				break;
			}
		} while(choice != 8);


		input.close();
	}

}
