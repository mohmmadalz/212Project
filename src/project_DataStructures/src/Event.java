
public class Event implements Comparable<Event> {
	private String title;
	private String date;
	private String location;
	private LinkedList<String> contacts;
	private boolean isEvent;   // true == Event   false == Appointment
	// add an aappointment
	// modify the class as requested

	public Event(String title, String date, String location, boolean isEvent) {
		this.title = title;
		this.location = location;
		this.date = date;
		contacts = new LinkedList<>();
		this.isEvent = isEvent;
	}

	public Event() {
		this.title = "";
		this.location = "";
		this.date = "";
		contacts = new LinkedList<>();
		this.isEvent = isEvent;

	}

	public void setContacts(LinkedList<String> contacts) {
		this.contacts = contacts;
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

	public LinkedList<String> getContacts() {
		return contacts;
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

	public void setisEvent(boolean Event){
		this.isEvent = Event ;
	}

	public boolean getisEvent(){
		return isEvent ;
	}

	@Override
	public int compareTo(Event otherEvent) {
		return this.title.compareTo(otherEvent.title);
	}

	public boolean addContact(String contactName) {
		if (contacts.empty()) {
			contacts.insert(contactName);
			return true;
		} else if (isEvent() && !contacts.find(contactName)) {
			contacts.insert(contactName);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteContact(String contactName) {
		if (contacts.find(contactName)) {
			contacts.remove();
			return true;
		}
		return false;
	}

	public String Info() {
		contacts.findFirst();

		if (isEvent) {
			String names = "";
			while (!contacts.last()) {
				names += contacts.retrieve() + ",";
				contacts.findNext();
			}
			names += contacts.retrieve();

			return ("\nEvent title: " + getTitle() +
					"\nContacts name: " + names +
					"\nEvent date and time (MM/DD/YYYY HH:MM):  " + date +
					"\nEvent location: " + location + "\n");
		} else {
			return ("\nAppointment title: " + getTitle() +
					"\nContacts name: " + contacts.retrieve() +
					"\nAppointment date and time (MM/DD/YYYY HH:MM):  " + date +
					"\nAppointment location: " + location + "\n");

		}
	}

	public boolean isEvent() {
		return isEvent;
	}

	public void setEvent(boolean isEvent) {
		this.isEvent = isEvent;
	}
}
