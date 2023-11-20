import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShannonFanoTest {

	@Test
    public void testShannonFano() {
		// Test cases involve passing an array of symbols with an adjacent array of their frequencies
		
        // Test case 1
        runShannonFanoTest(new String[]{"A", "B", "C", "D", "E"}, new int[]{30, 25, 20, 15, 10});

        // Test case 2
        runShannonFanoTest(new String[]{"W", "X", "Y", "Z"}, new int[]{40, 30, 20, 10});

        // Test case 3
        runShannonFanoTest(new String[]{"P", "Q", "R", "S", "T", "U"}, new int[]{5, 9, 12, 13, 16, 20});

        // Test case 4
        runShannonFanoTest(new String[]{"L", "M", "N", "O"}, new int[]{25, 25, 25, 25});

        // Test case 5
        runShannonFanoTest(new String[]{"F", "G", "H", "I", "J", "K"}, new int[]{1, 2, 3, 4, 5, 6});
        
        // Test case 6
        List<Node> nodes = runShannonFanoTest(
        				   new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"},
        				   new int[]{30, 15, 10, 10, 8, 6, 5, 5, 2, 2, 2, 2, 2, 1});
        
        
        // Compare hand-drawn codes (using the same logic) to the ones produced by the algorithm
        // Note: the symbols with equal frequencies may receive each others' codes
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

    private List<Node> runShannonFanoTest(String[] symbols, int[] frequencies) {
        System.out.println("\nRunning Shannon-Fano Test...");
        
        List<Node> nodes = ShannonFano.run(symbols, frequencies);
        return nodes;
    }
    
}
