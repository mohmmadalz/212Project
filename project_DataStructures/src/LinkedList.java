public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    
    // Inner Node class to represent elements in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
        //TestTestTestTestTest
        
    }
    
    // Constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
    }
    
    // Method to add a new element to the linked list
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
    
    // Method to search for an element in the linked list
    public T search(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Not found
    }
    
    // Method to delete an element from the linked list
    public void delete(T key) {
        if (head == null) {
            return; // Empty list
        }
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(key)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    // Method to print all elements in the linked list
    public void printAll() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Method to get the size of the linked list
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
