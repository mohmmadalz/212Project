package project_DataStructures.src; 
import java.util.Scanner;
public class Phonebook{
	    private LinkedList<Contact> contacts;
	    private LinkedList<Event> events;
		
	   
		public Phonebook() {
			contacts = new LinkedList<>();
	        events = new LinkedList<>();
		}
		
		public void addContact(Contact contact) {
			contacts.insert(contact);
		}
	    
		public boolean searchContact(int criteria) {
			String searchValue="";
			Scanner input = new Scanner(System.in);
			if(contacts.empty()) {
				input.close();
				return false;
			}
			contacts.findFirst();
			boolean found=false;
			switch (criteria) {
			case 1:
				System.out.println("Enter the contact's name: ");
				searchValue=input.nextLine();
				input.close();
				while(!found) {
					found=contacts.retrieve().getName().equalsIgnoreCase(searchValue);
					if(contacts.last() || found)
						return found;
					contacts.findNext();
				}
				return found;
			case 2:
				System.out.println("Enter the contact's PhoneNumber: ");
				searchValue=input.next();
				input.close();
				while(!found) {
					found=contacts.retrieve().getPhoneNumber().equalsIgnoreCase(searchValue);
					if(contacts.last() || found)
						return found;
					contacts.findNext();
				}
				return found;
			case 3:
				System.out.println("Enter the contact's EmailAddress: ");
				searchValue=input.next();
				input.close();
				while(!found) {
					found=contacts.retrieve().getEmailAddress().equalsIgnoreCase(searchValue);
					if(contacts.last() || found)
						return found;
					contacts.findNext();
				}
				return found;
			case 4:
				System.out.println("Enter the contact's Address: ");
				searchValue=input.nextLine();
				input.close();
				while(!found) {
					found=contacts.retrieve().getAddress().equalsIgnoreCase(searchValue);
					if(contacts.last() || found)
						return found;
					contacts.findNext();
				}
				return found;
			case 5:
				System.out.println("Enter the contact's Birthday: ");
				searchValue=input.next();
				input.close();
				while(!found) {
					found=contacts.retrieve().getBirthday().equalsIgnoreCase(searchValue);
					if(contacts.last() || found)
						return found;
					contacts.findNext();
				}
				return found;
			default:
				System.out.println("Invalid criteria");
				input.close();
				return false;				
			}

		}
	    
		public void deleteContact(String name) {
			// implement ...
		}
	    
	    public void scheduleEvent(Event event) {
	    	// implement ...
		}
	    
	    public void printContactsByFirstName(String firstName) {
	    	
	    }
	    
	    public void printAllEventsAlphabetically() {
	    	// implement ...
	    }

	    private boolean contactExists(Contact contact) {
	        return (searchContact(0))
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
					if(searchContact(criteria)) {
						System.out.println("Contact found!\r\n");
						contacts.retrieve().printInfo();
					}
					else {
						System.out.println("Contact not found");
					}
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