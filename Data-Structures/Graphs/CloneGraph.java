/**
 * Problem: Clone Graph
 * Link: https://leetcode.com/problems/clone-graph/
 * * Time Complexity: O(V + E) - We process every vertex and edge in the graph.
 * Space Complexity: O(V) - Space occupied by the HashMap and recursion stack.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If the node was already cloned, return the existing cloned instance
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a deep copy of the current node
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // Recursively clone all neighbor nodes
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}