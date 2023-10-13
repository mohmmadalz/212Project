
public class Contact implements Comparable<Contact> {
	
		private String name ;
		private String phoneNumber ;
		private String emailAddress;
		private String address ;
		private String birthday ;
		private String notes ;
		private LinkedList<Event> events;
		
		public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,String notes, LinkedList<Event> events){
	
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.emailAddress = emailAddress;
			this.address = address;
			this.birthday = birthday;
			this.notes = notes;
			this.events=events;
		}
		
		public Contact() {
			this.name = "";
			this.phoneNumber = "";
			this.emailAddress = "";
			this.address = "";
			this.birthday = null;
			this.notes = "";
			events = new LinkedList<Event>();
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
		
		 public LinkedList<Event> getEvents() {
			return events;
		}

		public void setEvents(LinkedList<Event> events) {
			this.events = events;
		}

		@Override
		    public int compareTo(Contact otherContact) {
		        return this.name.compareTo(otherContact.name);
		    }
	
		public void printInfo () {
		
			System.out.println("Name: " + name);
			System.out.println("Phone number: " + phoneNumber);
			System.out.println("Email addres: " + emailAddress);
			System.out.println("Address: " + address);
			System.out.println("Birthday: " + birthday);
		
		}	
		
		
	}
