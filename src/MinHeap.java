
public class MinHeap {
	
	private Node[] heap;
	private int size;		// acts as the last index
	
	public MinHeap(){
		heap = new Node[10];
		heap[0] = null;	// starts at 1 for easy indexing
		size = 0;
	}
	
	/**
	* enqueue - add the given Node to its proper place in the queue.
	* @param Node - the Node to add.
	* @return N/A
	*/
	public void enqueue(Node node) {
		if (size+1 >= heap.length)
			resize(2*heap.length);
		heap[size+1] = node;
		size++;
		
		bubbleUp(size);
	}
	
	/**
	* resize - resize the queue's size whenever it gets full to the given capacity.
	* @param capacity - the new capacity to change the queue to.
	* @return N/A
	*/
	private void resize(int capacity) {
		Node[] temp = new Node[capacity];
		size = capacity < size ? capacity:size;
		for (int i=0; i < heap.length; i++)
			temp[i] = heap[i];
		heap = temp;
	}
	
	/**
	* parent - return the index of the given index's parent node.
	* @param i - an index.
	* @return the index of the parent.
	*/
	private int parent(int i) {return i/2;}
	
	/**
	* left - return the index of the given index's left child node.
	* @param i - an index.
	* @return the index of the left child.
	*/
	private int left(int i) {return 2*i;}
	
	/**
	* right - return the index of the given index's right-child node.
	* @param i - an index.
	* @return the index of the right child.
	*/
	private int right(int i) {return 2*i + 1;}
	
	/**
	* bubbleUp - bubble up an element at the index to maintain its min-heap property.
	* @param i - an index.
	* @return N/A
	*/
	private void bubbleUp(int i) {
		if(i > 1) {		// If not already the top.
			if(heap[i].getFrequency() < heap[parent(i)].getFrequency()) { 
				Node parent = heap[parent(i)];
				heap[parent(i)] = heap[i];
				heap[i] = parent;
				bubbleUp(parent(i));	// check vs new parents
			}
		}
	}
	
	/**
	* bubbleDown - bubble down an element at the index to maintain its min-heap property.
	* @param i - an index.
	* @return N/A
	*/
	private void bubbleDown(int i) {
		// if within bounds
		if (left(i) <= size) {
			// find higher frequency child
			int hfChild = left(i);
			if (right(i) <= size && heap[right(i)].getFrequency() < heap[left(i)].getFrequency())
				hfChild = right(i);
			
			// check if we need to swap
			if (heap[hfChild].getFrequency() < heap[i].getFrequency()) {
				// swap with child of higher frequency
				Node swap = heap[hfChild];
				heap[hfChild] = heap[i];
				heap[i] = swap;		
				// recurse down
				bubbleDown(hfChild);
			}
		}
	}
	
	/**
	* dequeue - remove a Node from the heap.
	* @param N/A
	* @return the Node that was dequeued.
	*/
	public Node dequeue() throws Exception {
		if(size == 0)
			throw new Exception("No Nodes in the heap.");
		
		Node retNode = heap[1];
		heap[1] = heap[size];	// swap with last element in heap
		size--;
		bubbleDown(1);
		return retNode;
	}
	
	/**
	* peek - get the next Node in the queue without removing it.
	* @param N/A
	* @return the next Node in the queue.
	*/
	public Node peek() throws Exception {
		if(size == 0)
			throw new Exception("No Nodes in the queue.");
		return heap[1];
	}
	
	
	/**
	* isEmpty - check if the queue is empty.
	* @param N/A
	* @return true if the queue is empty.
	*/
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	* size - get the size of the heap / number of Nodes in the heap.
	* @param N/A
	* @return the size of the heap / number of Nodes in the heap.
	*/
	public int size() {
		return size;
	}
	
	/**
	* toString - get a clean String representation of array (not heap order).
	* @param N/A
	* @return the String representation of the array.
	*/
	@Override
	public String toString() {
		String ret = "{";
		for(int i=1; i<size+1; i++) {
			ret += heap[i].getName() + " (" + heap[i].getFrequency() + ")";
			if(i+1 < size+1)
				ret += ", ";
		}
		ret += "}";
		return ret;
	}
}


