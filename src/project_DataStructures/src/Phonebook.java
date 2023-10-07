package project_DataStructures.src; 
import java.util.Scanner;
public class Phonebook{
	    private LinkedList<Contact> contacts;
		
	   
		public Phonebook() {
			contacts = new LinkedList<>();
		}
		
		public void addContact(Contact contact) {
			contacts.insert(contact);
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
				input.close();
			    founded=searchByName(searchValue);
			    if(!founded.empty())
			    	printAllContacts(founded);
			    else
			    	System.out.println("contact not found");
				break;
			case 2:
				System.out.println("Enter the contact's PhoneNumber: ");
				searchValue=input.next();
				input.close();
				founded=searchByPhoneNumber(searchValue);
			    if(!founded.empty())
			    	printAllContacts(founded);
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
	    private LinkedList<Contact> searchByName(String name) {
	    	LinkedList<Contact> founded = new LinkedList<>();
	    	if(contacts.empty())
	    		return founded;
	    	contacts.findFirst();
	    	while(!contacts.last()) {
	    		if(contacts.retrieve().getName().equalsIgnoreCase(name))
	    			founded.insert(contacts.retrieve());
	    		contacts.findNext();
	    	}
	    	if(contacts.retrieve().getName().equalsIgnoreCase(name))
    			founded.insert(contacts.retrieve());
	    	return founded;
	    }
	    private LinkedList<Contact> searchByPhoneNumber(String PhoneNumber) {
	    	LinkedList<Contact> founded = new LinkedList<>();
	    	if(contacts.empty())
	    		return founded;
	    	contacts.findFirst();
	    	while(!contacts.last()) {
	    		if(contacts.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
	    			founded.insert(contacts.retrieve());
	    		contacts.findNext();
	    	}
	    	if(contacts.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
    			founded.insert(contacts.retrieve());
	    	return founded;
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
	    
		public void deleteContact(String name) {
			// implement ...
		}
	    
	    public void scheduleEvent(Event event) {
	    	// implement ...
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
	    
	    public void printAllEventsAlphabetically() {
	    	// implement ...
	    }

	    private boolean contactExists(Contact contact) {
	        return (searchByName(contact.getName()).empty() && searchByPhoneNumber(contact.getPhoneNumber()).empty());
	    }
	    
	    private boolean eventConflictExists(Event newEvent) {
	    	// implement ...
	        return false;
	    }
	    
	    private void deleteEventsWithContact(Contact contact) {
	        // implement ...
	    }
		
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
				switch (choice) {
				case 1: {
					Contact contact = new Contact();
					System.out.println("\nEnter the contact's name: ");
					contact.setName(input.nextLine());
					System.out.println("Enter the contact's phone number: ");
					contact.setPhoneNumber(input.next());
					System.out.println("Enter the contact's email address: ");
					contact.setEmailAddress(input.next());
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
					
				}
				case 4: {
					
				}
				case 5: {
					
				}
				case 6: {
					
				}
				case 7: {
					
				}
				case 8: {
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
				}
			} while(choice != 8);

			
			input.close();
		}

}