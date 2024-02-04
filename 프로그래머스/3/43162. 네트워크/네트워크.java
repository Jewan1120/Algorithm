import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (chk[i]) {
                continue;
            }
            answer++;
            Queue<Integer> que = new ArrayDeque<>();
            que.add(i);
            while (!que.isEmpty()) {
                int p = que.poll();
                if (chk[p]) {
                    continue;
                }
                chk[p] = true;
                for (int j = 0; j < computers.length; j++) {
                    if (chk[j] || computers[p][j] == 0) {
                        continue;
                    }
                    que.add(j);
                }
            }
        }
        return answer;
    }
}