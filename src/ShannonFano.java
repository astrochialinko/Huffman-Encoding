import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShannonFano {
    /**
     * It defines a set of symbols with corresponding frequencies, creates nodes for each symbol,
     * and sorts these nodes by frequency. It then applies the Shannon-Fano encoding algorithm to assign
     * binary codes to each symbol based on its frequency. Finally, it prints out the symbols and their assigned codes,
     * showcasing the results of the encoding process.
     * This method serves as a practical example of the algorithm's application.
     * @param args
     */
	public static void main(String[] args){
		return;
	}
	
    public static List<Node> run(String[] symbols, int[] frequencies) {
        // Create nodes for each symbol
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            nodes.add(new Node(symbols[i], frequencies[i]));
        }

        // Sort nodes by frequency in descending order
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node2.getFrequency() - node1.getFrequency();
            }
        });

        // Start the Shannon-Fano encoding process
        assignCodes(nodes, 0, nodes.size() - 1, "");

        // Print the codes
        for (Node node : nodes) {
            System.out.println("Symbol: " + node.getName() + ", Code: " + node.getCode());
        }
        return nodes;
    }

    /**
     *  It divides a list of nodes into two groups, ensuring a balanced distribution of frequencies.
     *  For each group, it appends '0' or '1' to the current code and recursively processes each subset.
     *  The method continues until all nodes have unique codes, adhering to the principle
     *  that more frequent symbols receive shorter codes.
     * @param nodes
     * @param start
     * @param end
     * @param code
     */
    private static void assignCodes(List<Node> nodes, int start, int end, String code) {
        if (start == end) {
            // Assign the current code to the single node in this segment
            nodes.get(start).setCode(code);
            return;
        }

        int totalFrequency = 0;
        for (int i = start; i <= end; i++) {
            totalFrequency += nodes.get(i).getFrequency();
        }

        int sum = 0, splitIndex = start;
        while (sum < totalFrequency / 2) {
            sum += nodes.get(splitIndex).getFrequency();
            splitIndex++;
        }

        // Recursively assign codes to each half
        assignCodes(nodes, start, splitIndex - 1, code + "0"); // First half
        assignCodes(nodes, splitIndex, end, code + "1"); // Second half
    }
}
