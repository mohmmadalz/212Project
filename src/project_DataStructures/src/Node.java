//*************Example***************
//
//CLASS: Node.java
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
public class Node<T> {

	public T data;  
	public Node<T> next; 
	public Node<T> previous;
	  
	public Node() {  
	    data=null;  
	    next=null;   
	}  
	  
	  
	public Node(T val) {  
	    data=val;  
	    next=null;  
	}  
	  
	  
	public T getData() {  
	    return data;  
	}  
	  
	  
	public void setData(T data) {  
	    this.data = data;  
	}  
	  
	  
	public Node<T> getNext() {  
	    return next;  
	}  
	  
	  
	public void setNext(Node<T> next) {  
	    this.next = next;  
	}  
}
