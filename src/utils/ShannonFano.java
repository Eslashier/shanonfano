
package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ShannonFano {
    private Map<Character, String> encodingTable;

    public ShannonFano() {
        encodingTable = new HashMap<Character, String>();
    }

    public Map<Character, String> getEncodingTable() {
        return encodingTable;
    }

    public void encode(char[] chars, int[] freqs) {
        if (chars == null || freqs == null || chars.length != freqs.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Node> leafNodes = new PriorityQueue<Node>();
        for (int i = 0; i < chars.length; i++) {
            leafNodes.offer(new Node(chars[i], freqs[i]));
        }

        while (leafNodes.size() > 1) {
            Node left = leafNodes.poll();
            Node right = leafNodes.poll();
            Node parent = new Node('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            leafNodes.offer(parent);
        }

        buildTable(leafNodes.poll(), "");
    }

    private void buildTable(Node node, String code) {
        if (node.isLeaf()) {
            encodingTable.put(node.c, code);
        } else {
            buildTable(node.left, code + "0");
            buildTable(node.right, code + "1");
        }
    }

    private static class Node implements Comparable<Node> {
        private char c;
        private int freq;
        private Node left;
        private Node right;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(freq, other.freq);
        }
    }
}