public class LinkedList<T extends Comparable<T>> implements List<T> {
	// for contact
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	// public void insert(T val) {

	// 	Node<T> newNode = new Node<T>(val);

	// 	if (empty()) {
	// 		current = head = newNode;
	// 	} else {
	// 		// Traverse the linked list to find the correct position to insert the new
	// 		// element
	// 		Node<T> prev = null;
	// 		Node<T> curr = head;
	// 		while (curr != null && curr.data.compareTo(val) < 0) {
	// 			prev = curr;
	// 			curr = curr.next;
	// 		}

	// 		// Insert the new element before the element that is greater than it
	// 		if (prev == null) {
	// 			newNode.next = head;
	// 			head = newNode;
	// 		} else {
	// 			prev.next = newNode;
	// 			newNode.next = curr;
	// 		}

	// 		current = newNode;
	// 	}
	// }
	public void insert (T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
		}
	}

	

	public void remove() {

		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

	// implement method to search if this contact is exist before.
	public T search(T value) {
		Node<T> tmp = head;
		while (tmp != null) {
			if (tmp.data.equals(value)) {
				return (T) tmp.data;
			}
			tmp = tmp.next;
		}
		return null;
	}
}
