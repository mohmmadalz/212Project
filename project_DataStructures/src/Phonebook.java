
	    private LinkedList<Contact> contacts;
	    private LinkedList<Event> events;
		
	   
		public Phonebook() {
			contacts = new LinkedList<>();
	        events = new LinkedList<>();
		}
		
		public void addContact(Contact contact) {
			// implement ...
		}
	    
		public void searchContact(String criteria, String searchValue) {
			// implement ...
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
		
