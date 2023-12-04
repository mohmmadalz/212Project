//*************Example***************
//
//CLASS: BSTNode.java
//
//CSC212 Data structures - Project phase II
//
//Fall 2023
//
//EDIT DATE: 3/12/2023
//
//
//
//TEAM: faiasl && mohmmed && mohmmed
//
//Team Name : Null Byet
//
//AUTHORS:
//
//443101660 faisal alhaqbani
//443100700 mohmmed alzobudi
//443101706 mohmmed almuhaitheef
//
////***********************************
public class BSTNode<T> {

	public String key;
	public T data;
	public BSTNode<T> left, right;
	// Creates a new instance of BSTNode

	public BSTNode(String k, T val) { // without left and right
		key = k;
		data = val;
		left = right = null;
	}

	public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) { // with left and right
		key = k;
		data = val;
		left = l;
		right = r;
	}

	public void setKey(String key2) {
		this.key = key2;
	}

	public void setData(T data2) {
		this.data = data2;
	}

	public void setLeft(BSTNode<T> p) {
		this.left = p;
	}

	public void setRight(BSTNode<T> p) {
		this.right = p;
	}

	public String getKey() {

		return key;
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
