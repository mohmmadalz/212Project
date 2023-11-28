public class BST<T> {

	BSTNode<T> root, current;

	public BST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findkey(String tkey) { // by name (string)
		BSTNode<T> p = root, q = root;

		if (empty())
			return false;

		while (p != null) {
			q = p;
			if (p.key == tkey) {
				current = p;
				return true;
			} else if (tkey.compareTo(p.key) > 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}

	public boolean insert(String k, T val) { // by name and data
		BSTNode<T> p, q = current;

		if (full() || findkey(k) || checkPhonenumberinorderTraversal(((Contact) val).getPhoneNumber())) {
			current = q; // findkey() modified current

			return false; // key already in the BST
		}

		p = new BSTNode<T>(k, val);

		if (empty()) {
			root = current = p;
			return true;
		} else {

			// current is pointing to parent of the new key
			if (k.compareTo(current.key) > 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}

	public boolean removeKey(String k) {
		String k1 = k;
		BSTNode p = root;
		BSTNode q = null; // Parent of p

		while (p != null) {

			if (k1.compareTo(p.getKey()) > 0) {
				q = p;
				p = p.getLeft();
			}

			else if (k1.compareTo(p.getKey()) < 0) {
				q = p;
				p = p.getRight();
			}

			else { // Found the key
					// Check the three cases

				// Case 3: two children
				if (p.getLeft() != null && p.getRight() != null) {

					BSTNode min = p.getRight(); // Search for the min in the right subtree
					q = p;

					while (min.getLeft() != null) {
						q = min;
						min = min.getLeft();
					}
					p.setKey(min.getKey());
					p.setData(min.getData());
					k1 = min.getKey();
					p = min;

					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.getLeft() != null) {
					// One child
					p = p.getLeft();
				} else {
					// One or no children
					p = p.getRight();
				}

				if (q == null) {
					// No parent for p, root must change
					root = p;
				} else {

					if (k1.compareTo(q.getKey()) < 0) {
						q.setLeft(p);
					} else {
						q.setRight(p);
					}

				}

				current = root;
			}

		}

		return false;
	}

	public boolean checkPhonenumberinorderTraversal(BSTNode<T> node, String phonenumber) {
		if (node != null) {
			if (checkPhonenumberinorderTraversal(node.getLeft(), phonenumber)) {
				return true; // PhoneNumber found in the left subtree
			}

			if (((Contact) node.getData()).getPhoneNumber().equals(phonenumber)) {
				return true; // PhoneNumber found in the current node
			}

			if (checkPhonenumberinorderTraversal(node.getRight(), phonenumber)) {
				return true; // PhoneNumber found in the right subtree
			}
		}
		return false; // PhoneNumber not found in this subtree
	}

	// Public method to start the inorder traversal from the root
	public boolean checkPhonenumberinorderTraversal(String phonenumber) {
		return checkPhonenumberinorderTraversal(root, phonenumber);
	}

}
