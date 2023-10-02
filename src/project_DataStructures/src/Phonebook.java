package project_DataStructures.src; 
import java.util.Scanner;
public class Phonebook{
	    private LinkedList<Contact> contacts;
	    private LinkedList<Event> events;
		
	   
		public Phonebook() {
			contacts = new LinkedList<>();
	        events = new LinkedList<>();
		}
		
		public boolean addContact(Contact contact) {
			contacts.insert(contact);
		}
	    
		public boolean searchContact(String criteria, String searchValue) {
			
		}
	    
		public void deleteContact(String name) {
			// implement ...
		}
	    
	    public void scheduleEvent(Event event) {
	    	// implement ...
		}
	    
	    public void printContactsByFirstName(String firstName) {
	    	// implement ...
	    }
	    
	    public void printAllEventsAlphabetically() {
	    	// implement ...
	    }

	    private boolean contactExists(Contact contact) {
	        return contacts.search(contact) != null;
	    }
	    
	    private boolean eventConflictExists(Event newEvent) {
	    	// implement ...
	        return false;
	    }
	    
	    private void deleteEventsWithContact(Contact contact) {
	        // implement ...
	    }
		
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			
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
			int choice= input.nextInt();
			while(choice != 8) {
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
					
					
					break;
				}
				case 2: {
					
				}
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
			}
			input.close();
		}

}