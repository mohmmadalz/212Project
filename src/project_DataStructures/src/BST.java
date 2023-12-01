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

		// by name (string)
	public boolean findkey(String tkey) { 
		BSTNode<T> p = root, q = root;

		if (empty())
			return false;

		while (p != null) {
			q = p;
			if (p.key.compareTo(tkey) == 0) {
				current = p;
				return true;
			} else if (tkey.compareTo(p.key) < 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}

			// add contact (option 1 in menu)
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
			if (k.compareTo(current.key) < 0)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}

	// delete contact (option 3 in menu)
	public boolean removeKey(String k) {
		String k1 = k;
		BSTNode p = root;
		BSTNode q = null; // Parent of p

		while (p != null) {

			if (k1.compareTo(p.getKey()) < 0) {
				q = p;
				p = p.getLeft();
			}

			else if (k1.compareTo(p.getKey()) > 0) {
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
				return true;
			}

		}

		return false;
	}

			// -------------helper methode for add contact------------- (this will check if Phone num is unique)
	private boolean checkPhonenumberinorderTraversal(BSTNode<T> node, String phonenumber) {
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
	private boolean checkPhonenumberinorderTraversal(String phonenumber) {
		return checkPhonenumberinorderTraversal(root, phonenumber);
	}



	// all method to print contact option 2 in menu

	private String result;

	  		//------------- contact by name (2.1) -------------
	public void printContactByName(String name) {
		if (findkey(name)) {
			System.out.println("Contact found!\n");
			((Contact) current.getData()).printInfo();
		}

	}


			// 	// ------------- contact by phoneNumber(2.2) -------------
	private void printContactByphoneNumberinorderTraversal(BSTNode<T> node, String phonenumber) {
		if (node != null) {
			printContactByphoneNumberinorderTraversal(node.getLeft(), phonenumber);
			if (((Contact) node.getData()).getPhoneNumber().equalsIgnoreCase(phonenumber)) {
				result += ((Contact) node.getData()).toString();

			}
			printContactByphoneNumberinorderTraversal(node.getRight(), phonenumber);
		}
	}

	// Public method to start the inorder traversal from the root
	public void printContactByphoneNumberinorderTraversal(String phonenumber) {
		result = "";

		printContactByphoneNumberinorderTraversal(root, phonenumber);
		if (result.split("Email addres:").length == 2) {
			System.out.println("Contact found!\n");
			System.out.println(result);

		} else if (result.isEmpty()) {
			return;
		} else {
			System.out.println("Contacts found!");
			System.out.println(result);

		}
	}


			// ------------- contact by Email(2.3) -------------
	private void printContactByEmailinorderTraversal(BSTNode<T> node, String email) {
		if (node != null) {
			printContactByEmailinorderTraversal(node.getLeft(), email);
			if (((Contact) node.getData()).getEmailAddress().equalsIgnoreCase(email)) {
				result += ((Contact) node.getData()).toString();

			}
			printContactByEmailinorderTraversal(node.getRight(), email);
		}
	}

	// Public method to start the inorder traversal from the root
	public void printContactByEmailinorderTraversal(String email) {
		result = "";

		printContactByEmailinorderTraversal(root, email);
		if (result.split("Email addres:").length == 2) {
			System.out.println("Contact found!\n");
			System.out.println(result);

		} else if (result.isEmpty()) {
			return;
		} else {
			System.out.println("Contacts found!");
			System.out.println(result);

		}
	}


			// ------------- contact by Addres(2.4) -------------
	private void printContactByAddressinorderTraversal(BSTNode<T> node, String address) {
		if (node != null) {
			printContactByAddressinorderTraversal(node.getLeft(), address);
			if (((Contact) node.getData()).getAddress().equalsIgnoreCase(address)) {
				result += ((Contact) node.getData()).toString();

			}
			printContactByAddressinorderTraversal(node.getRight(), address);
		}
	}

	// Public method to start the inorder traversal from the root
	public void printContactByAddressinorderTraversal(String address) {
		result = "";

		printContactByAddressinorderTraversal(root, address);
		if (result.split("Email addres:").length == 2) {
			System.out.println("Contact found!\n");
			System.out.println(result);

		} else if (result.isEmpty()) {
			return;
		} else {
			System.out.println("Contacts found!");
			System.out.println(result);

		}
	}


		// ------------- contact by BirthDay(2.5) -------------
	private void printContactByBirthDayinorderTraversal(BSTNode<T> node, String BirthDay) {
		if (node != null) {
			printContactByBirthDayinorderTraversal(node.getLeft(), BirthDay);
			if (((Contact) node.getData()).getBirthday().equalsIgnoreCase(BirthDay)) {
				result += ((Contact) node.getData()).toString();

			}
			printContactByBirthDayinorderTraversal(node.getRight(), BirthDay);
		}
	}

	// Public method to start the inorder traversal from the root
	public void printContactByBirthDayinorderTraversal(String BirthDay) {
		result = "";

		printContactByBirthDayinorderTraversal(root, BirthDay);
		if (result.split("Email addres:").length == 2) {
			System.out.println("Contact found!\n");
			System.out.println(result);

		} else if (result.isEmpty()) {
			return;
		} else {
			System.out.println("Contacts found!");
			System.out.println(result);

		}
	}	
	

			// all method to print contact with first name option 6 in menu
	private void printContactWithFirstNameinorderTraversal(BSTNode<T> node, String firstName) {
		if (node != null) {
			printContactWithFirstNameinorderTraversal(node.getLeft(), firstName);
			if (((Contact) node.getData()).getName().split(" ")[0].equalsIgnoreCase(firstName)) {
				result += ((Contact) node.getData()).toString();
			}
			printContactWithFirstNameinorderTraversal(node.getRight(), firstName);
		}
	}

	// Public method to start the inorder traversal from the root
	public void printContactWithFirstNameinorderTraversal(String firstName) {
		result = "";
		printContactWithFirstNameinorderTraversal(root, firstName);
		if (result.split("Email addres:").length == 2) {
			System.out.println("Contact found!\n");
			System.out.println(result);

		} else if (result.isEmpty()) {
			return;
		} else {
			System.out.println("Contacts found!");
			System.out.println(result);

		}
	}


}