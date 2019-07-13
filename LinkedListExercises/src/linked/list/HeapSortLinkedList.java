package linked.list;

public class HeapSortLinkedList {

	public Node sort(Node head, int numberOfNodes) {
 		for (int i = numberOfNodes / 2 - 1; i>=0;i--) {
			head = transformToHeap(head, i, numberOfNodes);
		}
 		for(int i=numberOfNodes-1;i>0;i--) {
 			head = moveFirstNodeToPosition(head, i);
 			head = transformToHeap(head, 0, i);
 		}
		return head;
	}

	private Node moveFirstNodeToPosition(Node head, int i) {
		Node nodeToBeMoved = bringNodeAtPosition(head, i);
		Node nodeAnteriorNodeToBeMoved = bringNodeAtPosition(head, i-1);
		Node nodeNextNodePositionToBeMoved = bringNodeAtPosition(head, i+1);
		Node currentNode = head;
		Node nextFirstNode = bringNodeAtPosition(head, 1);
		head = nodeToBeMoved;
		if(i!=1) {
		nodeAnteriorNodeToBeMoved.setNext(currentNode);
		nodeToBeMoved.setNext(nextFirstNode);
		}
		currentNode.setNext(nodeNextNodePositionToBeMoved);
		if(i==1) {
			nodeToBeMoved.setNext(currentNode);
		}
		
		return head;
	}

	public Node bringNodeAtPosition(Node head, int position) {
		if (position < 0) {
			return null;
		}
		int i = 0;
		Node demandedNode = head;
		while (i < position) {
			demandedNode = demandedNode.getNext();
			i++;
		}
		return demandedNode;
	}

	public Node transformToHeap(Node head, int currentPosition, int numberOfNodes) {
		int positionLargest = currentPosition;
		int positionLeft = 2 * currentPosition + 1;
		int positionRight = 2 * currentPosition + 2;
		if (positionLeft < numberOfNodes && bringNodeAtPosition(head, positionLeft).getValue() > bringNodeAtPosition(head, positionLargest).getValue()) {
			positionLargest = positionLeft;
		}
		if (positionRight < numberOfNodes && bringNodeAtPosition(head, positionRight).getValue() > bringNodeAtPosition(head, positionLargest).getValue()) {
			positionLargest = positionRight;
		}
		if (positionLargest != currentPosition) {
			head = interChangeNodes(head, currentPosition, positionLargest, numberOfNodes);
			head = transformToHeap(head, positionLargest, numberOfNodes);
		}

		return head;
	}

	private Node interChangeNodes(Node head, int currentPosition, int positionLargest, int numberOfNodes) {	
		Node nodeAnteriorCurrentPos  = bringNodeAtPosition(head, currentPosition-1);
		Node nodeAnteriorLargestPos = bringNodeAtPosition(head, positionLargest-1);
		Node nodeCurrentPos = bringNodeAtPosition(head, currentPosition);
		Node nodeLargestPos = bringNodeAtPosition(head, positionLargest);
		Node nodeNextCurrentPos = nodeCurrentPos.getNext();
		Node nodeNextLargestPos = nodeLargestPos.getNext();
		if(nodeAnteriorCurrentPos==null) {
			head = nodeLargestPos;
			if(positionLargest - currentPosition ==1) {
				nodeLargestPos.setNext(nodeCurrentPos);
				nodeCurrentPos.setNext(nodeNextLargestPos);
			}else {
				nodeCurrentPos.setNext(nodeNextLargestPos);
				nodeLargestPos.setNext(nodeNextCurrentPos);				
				nodeAnteriorLargestPos.setNext(nodeCurrentPos);
			}
		}else {
			if(positionLargest - currentPosition ==1) {
				nodeAnteriorCurrentPos.setNext(nodeLargestPos);
				nodeLargestPos.setNext(nodeCurrentPos);
				nodeCurrentPos.setNext(nodeNextLargestPos);
			}else {
				nodeCurrentPos.setNext(nodeNextLargestPos);
				nodeLargestPos.setNext(nodeNextCurrentPos);				
				nodeAnteriorCurrentPos.setNext(nodeLargestPos);
				nodeAnteriorLargestPos.setNext(nodeCurrentPos);
			}
		}
		return head;
	}

}
