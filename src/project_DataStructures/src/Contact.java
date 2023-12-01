public class Contact implements Comparable<Contact> {

	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private String birthday;
	private String notes;
	private LinkedList<Event> events;

	public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
			String notes) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		events = new LinkedList<>();

	}

	public Contact() {
		this.name = "";
		this.phoneNumber = "";
		this.emailAddress = "";
		this.address = "";
		this.birthday = null;
		this.notes = "";
		events = new LinkedList<>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int compareTo(Contact otherContact) {
		return this.name.compareTo(otherContact.name);
	}

	// it will add the event/appintment to contact
	public boolean addEvent(Event event) {
		if (!events.find(event)) {
			events.insert(event);
			return true;
		}
		return false;
	}
    
		// it will reomve the event/appintment from contact
	public boolean deleteEvent(Event event) {
		if (events.find(event)) {
			events.remove();
			return true;
		}
		return false;
	}

		// it will print the contact info 
	public void printInfo() {

		System.out.println("Name: " + name);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Email addres: " + emailAddress);
		System.out.println("Address: " + address);
		System.out.println("Birthday: " + birthday + "\n");

	}

	public LinkedList<Event> getEvents() {
		return events;
	}

	public void setEvents(LinkedList<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n"
				+ "Phone number: " + phoneNumber + "\n"
				+ "Email addres: " + emailAddress + "\n"
				+ "Address: " + address + "\n"
				+ "Birthday: " + birthday + "\n";
	}
}
