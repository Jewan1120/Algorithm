import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        HashMap<Integer, ArrayList<Integer>> goMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> toMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            goMap.put(i, new ArrayList<Integer>());
            toMap.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            goMap.get(edge[0]).add(edge[1]);
            toMap.get(edge[1]).add(edge[0]);
        }
        int s = 0;
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> goAl = goMap.get(i);
            ArrayList<Integer> toAl = toMap.get(i);
            if (goAl.size() >= 2 && toAl.size() == 0) {
                s = i;
                answer[0] = s;
                break;
            }
        }
        next: for (Integer node : goMap.get(s)) {
            Queue<Integer> que = new ArrayDeque<>();
            boolean[] chk = new boolean[n + 1];
            que.add(node);
            chk[node] = true;
            while (!que.isEmpty()) {
                int nowNode = que.poll();
                ArrayList<Integer> goAl = goMap.get(nowNode);
                ArrayList<Integer> toAl = toMap.get(nowNode);
                if (goAl.size() == 0) {
                    answer[2]++;
                    continue next;
                }
                if (goAl.size() == 2 && toAl.size() >= 2) {
                    answer[3]++;
                    continue next;
                }
                for (int i = 0; i < goAl.size(); i++) {
                    int nextNode = goAl.get(i);
                    if (!chk[nextNode]) {
                        chk[nextNode] = true;
                        que.add(nextNode);
                    }
                }
            }
            answer[1]++;
        }
        return answer;
    }
}