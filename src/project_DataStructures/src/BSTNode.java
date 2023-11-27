	
public class BSTNode <T> {
	
			public String key;
			public T data;
			public BSTNode<T> left, right;
			//faisal is here
			// Creates a new instance of BSTNode 
			
			public BSTNode(String k, T val) {      // without left and right
				key = k;
				data = val;
				left = right = null;
			}
			
			public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {     // with left and right
				key = k;
				data = val;
				left = l;
				right = r;
			}


			public void setKey(String key2) {
				this.key = key2;
			}

			

			public void setData(T data2) {
				this.data = data2 ;
			}
			
			

			public void setLeft(BSTNode<T> p) {
				this.left = p ;
			}

			public void setRight(BSTNode<T> p) {
				this.right = p ;
			}
			
			
			public String getKey() {
				
				return key ;
			}
			
			public T getData() {
				
				return data;
			}

			public BSTNode<T> getLeft() {
				
				return left;
			}

			public BSTNode<T> getRight() {
				
				return right;
			}
			
			
		}
	
	
	
