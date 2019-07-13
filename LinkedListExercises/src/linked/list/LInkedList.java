package linked.list;

public class LInkedList {

	private Node head;

	public void insertAtEnd(Node node) {
		Node currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = head.getNext();
		}
		currentNode.setNext(node);
	}

	public Node insertAtBegining(Node node) {
		node.setNext(head);
		head = node;
		return node;
	}
	
	public void setList(Node node) {
		this.head = node;
	}

	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
	}

	public Node removeDuplicates(Node node1) {
		Node iterator = node1;
		while (iterator!=null) {
			Node iteratorDoubling = iterator;
			while(iteratorDoubling!=null && iterator.getValue()==iteratorDoubling.getValue()) {
				iteratorDoubling = iteratorDoubling.getNext();
			}
			iterator.setNext(iteratorDoubling);
		 	iterator = iterator.getNext();
		}
		return node1;
	}
}
