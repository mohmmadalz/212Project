	public class Event implements Comparable<Event> {
	    // hi Mo is here
	    private String title;
	    private String date;
	    private String location;
	    private Contact eventuser;
	   
	
	    public Event(String title, String date, String location, Contact contact) {
	        this.title = title;
	        this.location = location;
	        this.eventuser = contact;
	        this.date = date;
	        
	
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
	     public void setEventuser(Contact eventuser) {
			this.eventuser = eventuser;
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
		
	     
	    public int compareTo(Event otherEvent) {
	        return title.compareTo(otherEvent.title);
	    }
	
	       public void addInfo(Event event) {
	        System.out.println("Event title: " + event.getTitle());
	        System.out.println("Contact name: " + eventuser);
	        System.out.println("Event date and time (MM/DD/YYYY HH:MM):  " + event.date );
	        System.out.println("Event location: " + event.location);
	    }
	}
