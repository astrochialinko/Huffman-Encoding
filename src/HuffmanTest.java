import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map.Entry;

public class HuffmanTest {

	@Test
	public void testHuffman1() throws Exception {
		HashMap<String, Integer> items = new HashMap<>();
		items.put("a", 5);
		items.put("b", 9);
		items.put("c", 12);
		items.put("d", 13);
		items.put("e", 16);
		items.put("f", 45);

		HashMap<String, String> expectedCodes = new HashMap<>();
		expectedCodes.put("f", "0");
		expectedCodes.put("c", "100");
		expectedCodes.put("d", "101");
		expectedCodes.put("a", "1100");
		expectedCodes.put("b", "1101");
		expectedCodes.put("e", "111");

		runHuffmanTest(items, expectedCodes);
	}

	@Test
	public void testHuffman2() throws Exception {
		HashMap<String, Integer> items = new HashMap<>();
		items.put("a", 17);
		items.put("b", 35);
		items.put("c", 17);
		items.put("d", 15);
		items.put("e", 16);

		HashMap<String, String> expectedCodes = new HashMap<>();
		expectedCodes.put("b", "0");
		expectedCodes.put("d", "100");
		expectedCodes.put("e", "101");
		expectedCodes.put("a", "110");
		expectedCodes.put("c", "111");

		runHuffmanTest(items, expectedCodes);
	}

	@Test
	public void testHuffman3() throws Exception {
		HashMap<String, Integer> items = new HashMap<>();
		items.put("A", 30);
		items.put("B", 15);
		items.put("C", 10);
		items.put("D", 10);
		items.put("E", 8);
		items.put("F", 6);
		items.put("G", 5);
		items.put("H", 5);
		items.put("I", 2);
		items.put("J", 2);
		items.put("K", 2);
		items.put("L", 2);
		items.put("M", 2);
		items.put("N", 1);

		HashMap<String, String> expectedCodes = new HashMap<>();
		expectedCodes.put("A", "10");
		expectedCodes.put("B", "110");
		expectedCodes.put("C", "001");
		expectedCodes.put("D", "010");
		expectedCodes.put("E", "1111");
		expectedCodes.put("F", "0111");
		expectedCodes.put("G", "0001");
		expectedCodes.put("H", "0110");
		expectedCodes.put("I", "00001");
		expectedCodes.put("J", "111001");
		expectedCodes.put("K", "00000");
		expectedCodes.put("L", "111011");
		expectedCodes.put("M", "111010");
		expectedCodes.put("N", "111000");

		runHuffmanTest(items, expectedCodes);
	}

	/**
	 * Recursively traverses the Huffman tree to collect the codes for each leaf
	 * node.
	 * 
	 * @param node  The current node being visited in the tree.
	 * @param code  The path taken as a binary string to reach the current node.
	 * @param codes The map where the character's Huffman code will be stored.
	 */
	private void collectCodes(Node node, String code, HashMap<String, String> codes) {
		// Base case: if the current node is null, just return.
		if (node == null)
			return;

		if (node.left() == null && node.right() == null) {
			// reached a leaf node, store the character and its code in the map
			codes.put(node.getName(), code);
		}

		// Traverse the left subtree by appending '0' to the code.
		collectCodes(node.left(), code + "0", codes);
		// Traverse the right subtree by appending '1' to the code.
		collectCodes(node.right(), code + "1", codes);
	}

	/**
	 * Executes a Huffman encoding test. Builds a Huffman tree from input
	 * frequencies, generates Huffman codes, and compares them with expected codes
	 * to verify correctness.
	 *
	 * @param items         Characters and their frequencies for Huffman tree
	 *                      construction.
	 * @param expectedCodes Expected Huffman codes for each character to validate
	 *                      encoding.
	 * @throws Exception If an error occurs during the Huffman tree construction or
	 *                   encoding process.
	 */
	private void runHuffmanTest(HashMap<String, Integer> items, HashMap<String, String> expectedCodes)
			throws Exception {
		// Build the Huffman tree
		HuffmanBuilder.buildTree(items);
		assertNotNull(HuffmanBuilder.head); // Check if the tree is not null

		// Collect the actual codes
		HashMap<String, String> actualCodes = new HashMap<>();
		collectCodes(HuffmanBuilder.head, "", actualCodes);

		// Test the Huffman Encoding
		for (Entry<String, String> entry : expectedCodes.entrySet()) {
			assertEquals(entry.getValue(), actualCodes.get(entry.getKey()));
		}
	}

}
