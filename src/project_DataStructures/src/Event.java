
public class Event implements Comparable<Event> {
	private String title;
	private String date;
	private String location;
	private Contact eventuser;
	private LinkedList<Contact> contacts;
	// add an aappointment
	// modify the class as requested

	public Event(String title, String date, String location, Contact contact) {
		this.title = title;
		this.location = location;
		this.eventuser = contact;
		this.date = date;
		contacts = new LinkedList<>();

	}

	public Event() {

	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

	public Contact getContact() {
		return eventuser;
	}

	public Contact getEventuser() {
		return eventuser;
	}

	public void setContacts(LinkedList<Contact> contacts) {
		this.contacts = contacts;
	}

	public LinkedList<Contact> getContacts() {
		return contacts;
	}

	public void setEventuser(Contact eventuser) {
		this.eventuser = eventuser;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int compareTo(Event otherEvent) {
		return this.title.compareTo(otherEvent.title);
	}

	public boolean addContact(Contact contact) {
		if (!contacts.find(contact)) {
			contacts.insert(contact);
			return true;
		}
		return false;
	}

	public boolean deleteContact(Contact contact) {
		if (contacts.find(contact)) {
			contacts.remove();
			return true;
		}
		return false;
	}

	public String Info() {
		return ("\nEvent title: " + getTitle() +
				"\nContact name: " + eventuser.getName() +
				"\nEvent date and time (MM/DD/YYYY HH:MM):  " + date +
				"\nEvent location: " + location + "\n");
	}
}
