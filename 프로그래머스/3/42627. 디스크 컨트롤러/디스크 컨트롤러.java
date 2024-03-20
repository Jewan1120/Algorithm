import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0, idx = 0, now = 0, cnt = 0, len = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while (idx < len) {
            while (cnt < len && jobs[cnt][0] <= now) {
                que.add(jobs[cnt++]);
            }
            if (que.isEmpty()) {
                now = jobs[cnt][0];
            } else {
                int[] job = que.poll();
                answer += (now - job[0]) + job[1];
                now += job[1];
                idx++;
            }
        }
        return answer / len;
    }
}