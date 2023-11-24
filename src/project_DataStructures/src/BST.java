	public class BST <T> {
		BSTNode<T> root, current;
		
		/** Creates a new instance of BST */
		public BST() {
			root = current = null;
		}
		
		public boolean empty() {
			return root == null;
		}
		
		public boolean full() {
			return false;
		}
		
		public T retrieve () {
			return current.data;
		}
		
	}
	
	
