import java.util.Scanner;

public class Phonebook {
	private BST<Contact> contacts;
	private LinkedList<Event> events;

	public Phonebook() {
		contacts = new BST<>();
		events = new LinkedList<>();

	}
	//

	public boolean addContact(Contact contact) {
		boolean flag = contacts.insert(contact.getName(), contact);
		if (!flag) {
			return false;
		}
		return true;

	}

	public void searchContact(int criteria) {
		String searchValue = "";
		Scanner input = new Scanner(System.in);
		switch (criteria) {

			case 1:
				System.out.print("\nEnter the contact's name:");
				searchValue = input.nextLine();
				System.out.print("");

				contacts.printContactByName(searchValue);
				break;

			case 2:
				System.out.print("\nEnter the contact's PhoneNumber:");
				searchValue = input.nextLine();
				System.out.print("");

				contacts.printContactByphoneNumberinorderTraversal(searchValue);

				break;

			case 3:
				System.out.print("\nEnter the contact's EmailAddress: ");
				searchValue = input.nextLine();
				System.out.print("");

				contacts.printContactByEmailinorderTraversal(searchValue);

				break;

			case 4:
				System.out.print("\nEnter the contact's Address:");
				searchValue = input.nextLine();
				System.out.print("");
				contacts.printContactByAddressinorderTraversal(searchValue);

				break;

			case 5:
				System.out.print("\nEnter the contact's Birthday:");
				searchValue = input.nextLine();
				System.out.print("");

				contacts.printContactByBirthDayinorderTraversal(searchValue);

				break;
			default:
				System.out.println("\nInvalid criteria");
				break;
		}

	}

	public void deleteContact(String contactName) {
		if (contacts.findkey(contactName)) {
			Contact temp = contacts.retrieve();
			if (contacts.removeKey(contactName)) {
				LinkedList<Event> contactEvents = temp.getEvents();
				while (contactEvents.hasNext()) {
					events.find(contactEvents.retrieve());
					events.retrieve().deleteContact(contactName);
					if (events.retrieve().getContacts().empty()) {
						events.remove();
					}
					contactEvents.findNext();
				}
				System.out.println("\nContact deleted successfully.");
				return;
			}
		}
	}

	public void printContactsByFirstName(String firstName) {
		contacts.printContactWithFirstNameinorderTraversal(firstName);
	}

	// -- event method --

	public void scheduleEvent(int criteria) {
		// 1- contact exist
		// 2- no conflict
		// 3- is it Event or appointment ?
		// check if the contact is exist in bst here
		String name;
		Scanner input = new Scanner(System.in);
		Event tmp = new Event();
		boolean contactsAdded = true;
		if (criteria == 1) {
			tmp.setEvent(true);
			System.out.print("\nEnter event title:");
			tmp.setTitle(input.nextLine());
			System.out.print("Enter contacts name separated by a comma: ");
			name = input.nextLine();
			System.out.print("");
			String[] names = name.split(",");
			for (int i = 0; i < names.length; i++) {
				contactsAdded = tmp.addContact(names[i]);
				if (!contactsAdded) {
					break;
				}
				if (!contacts.findkey(names[i])) {
					contactsAdded = false;
					break;
				}
			}
			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
			tmp.setDate(input.nextLine());
			System.out.print("Enter event location:");
			tmp.setLocation(input.nextLine());
			System.out.print("");

			tmp.setisEvent(true);
			if (contactsAdded && !eventConflictExists(tmp.getDate())) {
				events.insert(tmp);
				for (int i = 0; i < names.length; i++) {
					contacts.findkey(names[i]);
					contacts.retrieve().addEvent(tmp);
				}
				System.out.println("\nEvent scheduled successfully!");
				return;
			} else {
				System.out.println("\nEvent Scheduling failed ");
				return;

			}
		} else if (criteria == 2) {
			tmp.setEvent(false);
			System.out.print("\nEnter appointment title:");
			tmp.setTitle(input.nextLine());
			System.out.print("Enter contact name:");
			name = input.nextLine();
			tmp.addContact(name);
			System.out.print("Enter appointment date and time (MM/DD/YYYY HH:MM):");
			tmp.setDate(input.nextLine());
			System.out.print("Enter appointment location:");
			tmp.setLocation(input.nextLine());
			tmp.setEvent(false);
			if (!eventConflictExists(tmp.getDate()) && contacts.findkey(name)) {
				events.insert(tmp);
				contacts.findkey(name);
				contacts.retrieve().addEvent(tmp);
				System.out.println("\nAppointment scheduled successfully!");
			} else {
				System.out.println("\nAppointment Scheduling failed ");
			}
		}

	}

	public void PrintEventDetails(int criteria) {
		// by contact name pos1
		// by event title

		Scanner input = new Scanner(System.in);
		if (events.empty()) {
			System.out.println("\nEvent not found!");
			return;
		}
		events.findFirst();
		String result = "";
		int count = 0;
		switch (criteria) {
			case 1: {
				System.out.print("Enter the contact's name:");
				String contactName = input.nextLine();
				System.out.println();
				boolean contactFound = contacts.findkey(contactName);
				if (!contactFound) {
					System.out.println("Contact doesn't exist!");
					return;
				}
				LinkedList<Event> temp = contacts.retrieve().getEvents();
				while (!temp.last()) {
					result += temp.retrieve().Info();
					temp.findNext();
					count++;
				}
				result += temp.retrieve().Info();
				count++;
				if (count == 1) {
					System.out.print(result.split(" ")[0] + " found!");
					System.out.println(result);
				} else if (count > 1) {
					System.out.print("Events/Appointments found!");
					System.out.println(result);
				} else {
					System.out.println("no Events/Appointments found!");
				}
				break;
			}
			case 2: {
				System.out.print("Enter the event title:");
				String eventTitle = input.nextLine();
				while (!events.last()) {
					if (events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
						result += events.retrieve().Info();

					}
					events.findNext();
				}
				if (events.retrieve().getTitle().equalsIgnoreCase(eventTitle)) {
					result += events.retrieve().Info();
				}
				if (result != "") {
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
		// CHANGE THE METHOD TO PRINT APPOINTMENTS TOO

		if (events.empty())
			return;
		String result = "";
		events.findFirst();
		while (!events.last()) {
			result += events.retrieve().Info();
			events.findNext();
		}
		result += events.retrieve().Info();

		System.out.println(result);
	}

	// -- helper methods for event --

	private boolean eventConflictExists(String date) {
		if (events.empty()) {
			return false; // empty
		}
		events.findFirst();
		while (events.hasNext()) {
			if (events.retrieve().getDate().equalsIgnoreCase(date)) // list without the last
				return true;
			events.findNext();
		}
		return false;
	}

	// main

	public void menu() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			String menu = "\nWelcome to the Linked Tree Phonebook!\r\n"
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
				choice = input.nextInt();
				input.nextLine();
			} catch (Exception e) {
				choice = 9;
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
					if (addContact(contact)) {
						System.out.println("\nContact added successfully!");
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
						int criteria = input.nextInt();
						searchContact(criteria);
					} catch (Exception e) {
						System.out.println("\ninvalid input!\n");
						choice = 9;
						input.next();
						break;
					}
					break;
				}
				case 3: {
					System.out.print("Enter the contact's name:");
					deleteContact(input.nextLine());
					break;
				}
				case 4: {
					System.out.print("Enter type:\n" +
							"1. event\n" +
							"2. appointment\n" +
							"\nEnter your choice:");
					try {
						int criteria = input.nextInt();
						scheduleEvent(criteria);
					} catch (Exception e) {
						System.out.println("\ninvalid input!\n");
						choice = 9;
						input.next();
						break;
					}
					break;
				}
				case 5: {
					System.out.print("Enter search criteria:\r\n"
							+ "1. contact name\r\n"
							+ "2. Event title\r\n"
							+ "Enter your choice:");
					try {
						int criteria = input.nextInt();
						PrintEventDetails(criteria);
						break;
					} catch (Exception e2) {
						System.out.println("\ninvalid input!\n");
						choice = 9;
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
					System.out.println("\ninvalid input! try again \n");
					;
					break;
			}
		} while (choice != 8);

		input.close();
	}

}
