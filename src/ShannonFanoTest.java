import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class ShannonFanoTest {

	@Test
	public void testShannonFano1() {
		List<Node> nodes = runShannonFanoTest(new String[] { "A", "B", "C", "D", "E" },
				new int[] { 30, 25, 20, 15, 10 });

		assertEquals("00", nodes.get(0).getCode());
		assertEquals("01", nodes.get(1).getCode());
		assertEquals("100", nodes.get(2).getCode());
		assertEquals("101", nodes.get(3).getCode());
		assertEquals("11", nodes.get(4).getCode());
	}

	@Test
	public void testShannonFano2() {
		List<Node> nodes = runShannonFanoTest(new String[] { "W", "X", "Y", "Z" }, new int[] { 40, 30, 20, 10 });

		assertEquals("00", nodes.get(0).getCode());
		assertEquals("01", nodes.get(1).getCode());
		assertEquals("10", nodes.get(2).getCode());
		assertEquals("11", nodes.get(3).getCode());
	}

	@Test
	public void testShannonFano3() {
		List<Node> nodes = runShannonFanoTest(new String[] { "P", "Q", "R", "S", "T", "U" },
				new int[] { 5, 9, 12, 13, 16, 20 });

		assertEquals("000", nodes.get(0).getCode());
		assertEquals("001", nodes.get(1).getCode());
		assertEquals("01", nodes.get(2).getCode());
		assertEquals("100", nodes.get(3).getCode());
		assertEquals("101", nodes.get(4).getCode());
		assertEquals("11", nodes.get(5).getCode());
	}

	@Test
	public void testShannonFano4() {
		List<Node> nodes = runShannonFanoTest(new String[] { "L", "M", "N", "O" }, new int[] { 25, 25, 25, 25 });

		assertEquals("00", nodes.get(0).getCode());
		assertEquals("01", nodes.get(1).getCode());
		assertEquals("10", nodes.get(2).getCode());
		assertEquals("11", nodes.get(3).getCode());
	}

	@Test
	public void testShannonFano5() {
		List<Node> nodes = runShannonFanoTest(new String[] { "F", "G", "H", "I", "J", "K" },
				new int[] { 1, 2, 3, 4, 5, 6 });

		assertEquals("00", nodes.get(0).getCode());
		assertEquals("01", nodes.get(1).getCode());
		assertEquals("100", nodes.get(2).getCode());
		assertEquals("101", nodes.get(3).getCode());
		assertEquals("110", nodes.get(4).getCode());
		assertEquals("111", nodes.get(5).getCode());
	}

	@Test
	public void testShannonFano6() {
		List<Node> nodes = runShannonFanoTest(
				new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" },
				new int[] { 30, 15, 10, 10, 8, 6, 5, 5, 2, 2, 2, 2, 2, 1 });

		assertEquals("00", nodes.get(0).getCode());
		assertEquals("010", nodes.get(1).getCode());
		assertEquals("011", nodes.get(2).getCode());
		assertEquals("1000", nodes.get(3).getCode());
		assertEquals("1001", nodes.get(4).getCode());
		assertEquals("101", nodes.get(5).getCode());
		assertEquals("1100", nodes.get(6).getCode());
		assertEquals("1101", nodes.get(7).getCode());
		assertEquals("111000", nodes.get(8).getCode());
		assertEquals("111001", nodes.get(9).getCode());
		assertEquals("11101", nodes.get(10).getCode());
		assertEquals("11110", nodes.get(11).getCode());
		assertEquals("111110", nodes.get(12).getCode());
		assertEquals("111111", nodes.get(13).getCode());
	}

	/**
	 * Runs a test for the Shannon-Fano encoding algorithm.
	 * 
	 * @param symbols     An array of string symbols that are to be encoded.
	 * @param frequencies An array of integers representing the frequency of each
	 *                    corresponding symbol.
	 * @return A list of Node objects that contains the encoded symbols and their
	 *         codes.
	 */
	private List<Node> runShannonFanoTest(String[] symbols, int[] frequencies) {
		System.out.println("\nRunning Shannon-Fano Test...");

		List<Node> nodes = ShannonFano.run(symbols, frequencies);
		return nodes;
	}

}
