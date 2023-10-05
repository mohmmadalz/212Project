public class Event {
//hi Mo is here
    private String title;
    private String date;
    private String location;
    private Contact contact;

    public Event(String title, String date, String location, Contact contact) {
        this.title = title;
        this.location = location;
        this.contact = contact;
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
          return contact;
      }
    

      public void addInfo (Event event){
			System.out.println("Note: " + event.getTitle());
			
      }
}
