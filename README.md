# 212Project
Project Title: Linked List Phonebook

Project Description: In this project, you will create a phonebook application that stores contact
information using a linked list data structure. The application will allow users to add, search, and delete
contacts from the phonebook. You will need to implement advanced search functionality that allows users
to search for contacts based on multiple criteria (e.g., name, phone number, email address). Additionally,
you need to be able to schedule events and appointments with contacts.


Classes to be implemented:

1. Contact: This class will represent a single contact in the phonebook. It should have fields for the
contact’s name, phone number, email address, address, birthday, and notes. 

2. LinkedList ADT: This class will represent the linked list data structure used to store the contacts.
It should have methods for adding, searching, and deleting contacts from the list.

3. Phonebook: This class will represent the phonebook application itself. It should have a field for
the linked list ADT that stores the contacts and methods for interacting with the list (e.g., adding,
searching, and deleting contacts). You will also need to schedule events and appointments with
contacts.

4. Event: This class will represent events or appointment that can be scheduled with a contact. It
should have fields for the event title, date and time, location, and the contact involved in this
event.



Project Requirements:

• The Contact class should implement the Comparable interface so that contacts can be sorted by name
when added to the linked list.

• The Phonebook class should provide a user-friendly interface for interacting with the phonebook (e.g.,
through a command-line menu or graphical user interface).

• Each contact in the phonebook should be unique. You can ensure this by checking if a contact with
the same name or phone number already exists in the list before adding a new contact.

• When you search for a contact by email address, address, or birthday, you should return all contacts
that have these values

• The Phonebook class should have methods for printing all contacts that share an event as well as all
contacts that share the first name.

• In the event class, use any data structure you choose to store the events. You might have to include
the event class object in another class. This problem is for you to solve.

• the search for an event is based on the event title or contact name.

• When a contact is deleted all events with that contact are also deleted.

• Make sure before adding an event that the contact in the event exist in the contact list.

• Write a method that will list all events available ordered alphabetically by event name in O(n) time.
• There should be no conflict in event scheduling. A new event should not be scheduled for a contact if
it has a conflict with a current scheduled event
