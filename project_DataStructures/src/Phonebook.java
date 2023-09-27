import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//HI Mo502
class Contact implements Comparable<Contact> {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private Date birthday;
    private String notes;

    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) throws ParseException {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.birthday = dateFormat.parse(birthday);
        this.notes = notes;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return "Name: " + name + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email Address: " + emailAddress + "\n" +
                "Address: " + address + "\n" +
                "Birthday: " + dateFormat.format(birthday) + "\n" +
                "Notes: " + notes;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getBirthday() {
        return birthday;
    }
}

class Event {
    private String eventTitle;
    private Date dateTime;
    private String location;
    private Contact contact;

    public Event(String eventTitle, String dateTime, String location, Contact contact) throws ParseException {
        this.eventTitle = eventTitle;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        this.dateTime = dateFormat.parse(dateTime);
        this.location = location;
        this.contact = contact;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return "Event title: " + eventTitle + "\n" +
                "Date and Time: " + dateFormat.format(dateTime) + "\n" +
                "Location: " + location + "\n" +
                "Contact: " + contact.getName();
    }
}

class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T search(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.compareTo(key) == 0) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(T key) {
        if (head == null) {
            return;
        }
        if (head.data.compareTo(key) == 0) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.compareTo(key) == 0) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void printAll() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class PhoneBook {
    private LinkedList<Contact> contacts;
    private LinkedList<Event> events;

    public PhoneBook() {
        contacts = new LinkedList<>();
        events = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        if (!contactExists(contact)) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Contact with the same name already exists.");
        }
    }

    public void searchContact(String criteria, String searchValue) {
        switch (criteria) {
            case "1":
                Contact foundContact = contacts.search(new Contact(searchValue));
                if (foundContact != null) {
                    System.out.println("Contact found!");
                    System.out.println(foundContact);
                } else {
                    System.out.println("Contact not found.");
                }
                break;
            case "2":
                // Implement searching by phone number
                break;
            case "3":
                // Implement searching by email address
                break;
            case "4":
                // Implement searching by address
                break;
            case "5":
                // Implement searching by birthday
                break;
            default:
                System.out.println("Invalid criteria.");
        }
    }

    public void deleteContact(String name) {
        Contact contactToDelete = contacts.search(new Contact(name));
        if (contactToDelete != null) {
            contacts.delete(contactToDelete);
            deleteEventsWithContact(contactToDelete);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void scheduleEvent(Event event) {
        if (contactExists(event.getContact())) {
            if (!eventConflictExists(event)) {
                events.add(event);
                System.out.println("Event scheduled successfully!");
            } else {
                System.out.println("Event scheduling conflict. Please choose another date/time.");
            }
        } else {
            System.out.println("Contact does not exist. Cannot schedule the event.");
        }
    }

    public void printEventDetails(String criteria, String searchValue) {
        switch (criteria) {
            case "1":
                // Implement printing events by contact name
                break;
            case "2":
                // Implement printing events by event title
                break;
            default:
                System.out.println("Invalid criteria.");
        }
    }

    public void printContactsByFirstName(String firstName) {
        // Implement printing contacts by the first name
    }

    public void printAllEventsAlphabetically() {
        // Implement printing all events sorted alphabetically by event name
    }

    private boolean contactExists(Contact contact) {
        return contacts.search(contact) != null;
    }

    private boolean eventConflictExists(Event newEvent) {
        // Implement checking for event conflicts
        return false;
    }

    private void deleteEventsWithContact(Contact contact) {
        // Implement deleting events associated with a contact
    }

    public static void main(String[] args) throws ParseException {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Linked List Phonebook!");

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Schedule an event");
            System.out.println("5. Print event details");
            System.out.println("6. Print contacts by first name");
            System.out.println("7. Print all events alphabetically");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a contact
                    System.out.print("Enter the contact's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter the contact's email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter the contact's address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter the contact's birthday (MM/dd/yyyy): ");
                    String birthday = scanner.nextLine();
                    System.out.print("Enter any notes for the contact: ");
                    String notes = scanner.nextLine();

                    Contact contact = new Contact(name, phoneNumber, email, address, birthday, notes);
                    phoneBook.addContact(contact);
                    break;

                case 2:
                    // Search for a contact
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Name");
                    System.out.println("2. Phone Number");
                    System.out.println("3. Email Address");
                    System.out.println("4. Address");
                    System.out.println("5. Birthday");
                    System.out.print("Enter your choice: ");
                    String searchCriteria = scanner.nextLine();
                    System.out.print("Enter the search value: ");
                    String searchValue = scanner.nextLine();

                    phoneBook.searchContact(searchCriteria, searchValue);
                    break;

                case 3:
                    // Delete a contact
                    System.out.print("Enter the name of the contact to delete: ");
                    String contactNameToDelete = scanner.nextLine();
                    phoneBook.deleteContact(contactNameToDelete);
                    break;

                case 4:
                    // Schedule an event
                    System.out.print("Enter event title: ");
                    String eventTitle = scanner.nextLine();
                    System.out.print("Enter contact name: ");
                    String eventContactName = scanner.nextLine();
                    System.out.print("Enter event date and time (MM/dd/yyyy HH:mm): ");
                    String eventDateTime = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String eventLocation = scanner.nextLine();

                    Contact eventContact = phoneBook.contacts.search(new Contact(eventContactName));
                    if (eventContact != null) {
                        Event event = new Event(eventTitle, eventDateTime, eventLocation, eventContact);
                        phoneBook.scheduleEvent(event);
                    } else {
                        System.out.println("Contact does not exist. Cannot schedule the event.");
                    }
                    break;

                case 5:
                    // Print event details
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Contact name");
                    System.out.println("2. Event title");
                    System.out.print("Enter your choice: ");
                    String eventCriteria = scanner.nextLine();
                    System.out.print("Enter the search value: ");
                    String eventSearchValue = scanner.nextLine();

                    phoneBook.printEventDetails(eventCriteria, eventSearchValue);
                    break;

                case 6:
                    // Print contacts by first name
                    System.out.print("Enter the first name: ");
                    String firstName = scanner.nextLine();
                    phoneBook.printContactsByFirstName(firstName);
                    break;

                case 7:
                    // Print all events alphabetically
                    phoneBook.printAllEventsAlphabetically();
                    break;

                case 8:
                    // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
