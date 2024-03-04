# Project Title: Binary search tree Phonebook

Project Description: In this project, you will create a phonebook application that stores contact
information using a BST data structure. The application will allow users to add, search, and delete contacts
from the phonebook. You will need to implement advanced search functionality that allows users to
search for contacts based on name in logarithmic time. Additionally, you need to be able to schedule
events and appointments with contacts.

Classes to be implemented:

1. Contact: This class will represent a single contact in the phonebook. It should have fields for the
contact’s name, a phone number, email address, address, birthday, and notes.

2. Contact BST : This class will represent the BST data structure used to store the contacts (you will
only use one BST to store contacts).

3. Phonebook: This class will represent the phonebook application itself. It should have a field for
the BST ADT that stores the contacts.). You will also need to schedule events and appointments
with contacts.

4. Event: This class will represent an event or an appointment that can be scheduled with a contact
or multiple contacts. An event can be scheduled with multiple contacts, where an appointment
can be scheduled only with one contact. It should have fields to represent if it is an event or an
appointment, the title, date and time, location, and the contacts involved in this event or
appointment.

Project Requirements:

• The Contact class should implement the Comparable interface so that contacts can be sorted by name
when added to the BST.

• The Phonebook class should provide a user-friendly interface for interacting with the phonebook (e.g.,
through a command-line menu or graphical user interface).

• Each contact in the phonebook should be unique. The contact is unique in their name and phone
number. You will use the name as the key in the BST, so that will already need to be unique. For the
phone number, you can ensure this by checking if a contact with the same phone number already
exists in the BST (using in order traversal) before adding a new contact.

• The Phonebook class should have a method for printing all contacts that share the first name. The
first name is different from the contact’s name, you can get the first name by searching for the first
space in the contact’s name.

• In the event class, use any data structure you choose to store the events/appointments. You might
have to include the event class object in another class. This problem is for you to solve.

• Print all events or appointments that share the same title or contact name.

• When a contact is deleted, all appointments with that contact are also deleted. If the contact belonged
in a scheduled event, then he should be removed from the event. Make sure before adding an event
or appointment that the contact in the event exist in the contact BST. All contacts need to be in the
contact BST before an event is added.

• Write a method that will list all events and appointments available ordered alphabetically by
event/appointment name in O(n) time.

• There should be no conflict in event/appointment scheduling. A new event should/appointment not
be scheduled for a contact if it has a conflict with a current scheduled event/appointment that the
phonebook user has.
