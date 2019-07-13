package linked.list;

public class Node {
	
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		String str = 	System.lineSeparator()+value;
		if(next!=null) {
			str+=next.toString();
		}
		return str;
	}
}
