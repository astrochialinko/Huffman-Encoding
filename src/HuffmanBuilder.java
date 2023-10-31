import java.util.HashMap;

public class HuffmanBuilder {

	static Node head = null;

	public static void main(String[] args) {
		HashMap<String, Integer> items = new HashMap<>();
		items.put("a", 5);
		items.put("b", 9);
		items.put("c", 12);
		items.put("d", 13);
		items.put("e", 16);
		items.put("f", 45);
		buildTree(items);
		getCodes(head, "");
	}

	/**
	 * buildTree method uses a key, value pairing of values and frequencies to create a priority
	 * queue for Node objects made from the pairs. It
	 * @param items - the key, value pairs of elements and their frequencies.
	 */
	public static void buildTree(HashMap<String, Integer> items) {

		MinHeap queue = new MinHeap();

		for (String key : items.keySet()) {
			queue.enqueue(new Node(key, items.get(key)));
		}

		while (queue.size() >= 2) { // while there are still pairs of nodes to remove.

			try {
				// remove the two smallest nodes from the heap
				Node first = queue.dequeue();
				Node second = queue.dequeue();
				
				// create a node with the sum of the frequencies of the two smallest nodes
				Node sum = new Node(first.getFrequency() + second.getFrequency());

				// set the left and right children of the new node.
				sum.setLeft(first);
				sum.setRight(second);

				
				head = sum;

				// add new node to the queue.
				queue.enqueue(sum);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * getCodes traverses the binary Huffman tree and sets each node's code value
	 * according to the path within the tree, as well as printing it out.
	 */
	public static void getCodes(Node curr, String code) {
		
		// Base case: if current node is a leaf
		if (curr.left() == null && curr.right() == null) {
			System.out.println(curr.getName() + ": " + code);
			return;
		}
		
		getCodes(curr.left(), code + "0");
		getCodes(curr.right(), code + "1");
	}

}
