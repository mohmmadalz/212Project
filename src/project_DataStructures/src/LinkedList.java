public class LinkedList<T extends Comparable<T>> {
	// for event
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

	public boolean hasNext() {
		return current.next != null;
	}

	public boolean isFirst() {
		return current == head;
	}

	// add
	public void insert(T val) {
		Node<T> newNode = new Node<T>(val);
		if (empty()) {
			head = newNode;
			current = head;
			return;
		}
		if (head.data.compareTo(val) > 0) {
			// If the list is empty or the new value is smaller than the head, insert at the
			// beginning
			newNode.next = head;
			head = newNode;
			current = head;
		} else {
			Node<T> tmp = head;

			// Find the correct position to insert the new value
			while (tmp.next != null && tmp.next.data.compareTo(val) < 0) {
				tmp = tmp.next;
			}

			// Insert the new value in the correct position
			newNode.next = tmp.next;
			tmp.next = newNode;
			current = newNode;
		}
	}

	//remove
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

	//find
	public Boolean find(T value) {
		Node<T> tmp = head;
		while (tmp != null) {
			if (tmp.data.compareTo(value) == 0) {
				current = tmp;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
}
