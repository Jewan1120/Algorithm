import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    static class Node {
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    public int solution(int n, int[][] edge) {
        boolean[] chk = new boolean[n + 1];
        HashMap<Integer, ArrayList<Integer>> nodeMap = new HashMap<>();
        for (int[] node : edge) {
            if (!nodeMap.containsKey(node[0])) {
                nodeMap.put(node[0], new ArrayList<>());
            }
            if (!nodeMap.containsKey(node[1])) {
                nodeMap.put(node[1], new ArrayList<>());
            }
            nodeMap.get(node[0]).add(node[1]);
            nodeMap.get(node[1]).add(node[0]);
        }
        Deque<Node> deq = new ArrayDeque<>();
        chk[0] = chk[1] = true;
        deq.push(new Node(1, 0));
        int depth = 0;
        ArrayList<Integer> nodeArr = new ArrayList<>();
        while (!deq.isEmpty()) {
            Node node = deq.pollFirst();
            if (depth < node.d) {
                depth = node.d;
                nodeArr.clear();
            }
            nodeArr.add(node.n);
            ArrayList<Integer> adjacent = nodeMap.get(node.n);
            for (int i : adjacent) {
                if (!chk[i]) {
                    chk[i] = true;
                    deq.offerLast(new Node(i, node.d + 1));
                }
            }
        }
        return nodeArr.size();
    }
}