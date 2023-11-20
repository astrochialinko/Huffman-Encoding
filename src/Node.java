/*
 * This class contains the Node object that will be used to contain values and codes of 
 * nodes that are added to our Huffman tree and our Shannon-Fano structure.
 */

public class Node {
	
	private String name;
	private int frequency;
	private Node leftChild;
	private Node rightChild;
	private String code;
	
	public Node(String name, int frequency) {
		this.name = name;
		this.frequency = frequency;
		leftChild = null;
		rightChild = null;
		code = "";
	}
	
	public Node(int frequency) {
		this.name = "";
		this.frequency = frequency;
		leftChild = null;
		rightChild = null;
		code = "";
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String newCode){
		code = newCode;
	}
	
	public Node left() {
		return leftChild;
	}
	
	public Node right() {
		return rightChild;
	}
	
	public void setLeft(Node node) {
		leftChild = node;
	}
	
	public void setRight(Node node) {
		rightChild = node;
	}

}
