package linked.list;
/**
 * 
 * @author george
 *1)write the code to remove duplicates from an unsorted linked list
 *2)how would you solve the problem if duplicates are not allowed
 */
public class RemoveDumps_2_1 {
	public static void main(String[] args) {
		Node node1 = new Node(2);
		Node node2 = new Node(4);
		Node node3 = new Node(6);
		Node node4 = new Node(7);
		Node node5 = new Node(5);
		Node node6 = new Node(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		LInkedList linkedList = new LInkedList();
		linkedList.setList(node1);
		linkedList.printList();
		HeapSortLinkedList heapSortLinkedList = new HeapSortLinkedList();
		linkedList.setList(heapSortLinkedList.sort(node1,  6));
		System.out.println(System.lineSeparator());
		linkedList.printList();
		node1 = linkedList.removeDuplicates(node1);
		System.out.println(System.lineSeparator());
		linkedList.printList();
	}
}
