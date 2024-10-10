import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    
    int min = Integer.MAX_VALUE;
    ArrayList<ArrayList<int[]>> refineReqs;
    int[][] waitingTimes;
    int[] consultCombi;

    public int solution(int k, int n, int[][] reqs) {
        refineReqs = new ArrayList<>();
        consultCombi = new int[k + 1];
        waitingTimes = new int[k + 1][n - k + 2];
        for (int i = 0; i < k + 1; i++)
            refineReqs.add(new ArrayList<>());
        for (int[] req : reqs) {
            refineReqs.get(req[2]).add(new int[] { req[0], req[1] });
        }
        calWaitingTime(k, n);
        makeConsultCombi(k, n, 1);
        return min;
    }

    private void calWaitingTime(int k, int n) {
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < n - k + 2; j++) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                int totalWaitingTime = 0;
                for (int[] req : refineReqs.get(i)) {
                    if (pq.size() < j) {
                        pq.add(req[0] + req[1]);
                        continue;
                    }
                    int now = pq.poll();
                    int waitingTime = now - req[0];
                    if (waitingTime > 0) {
                        totalWaitingTime += waitingTime;
                        pq.add(now + req[1]);
                    } else
                        pq.add(req[0] + req[1]);
                }
                waitingTimes[i][j] = totalWaitingTime;
            }
        }
    }

    private void makeConsultCombi(int k, int remaining, int depth) {
        if (depth == k) {
            consultCombi[depth] += remaining;
            int totalWaitingTime = 0;
            for (int i = 1; i < k + 1; i++) {
                totalWaitingTime += waitingTimes[i][consultCombi[i]];
            }
            min = Math.min(min, totalWaitingTime);
            consultCombi[depth] -= remaining;
            return;
        }
        for (int i = 1; i < remaining; i++) {
            consultCombi[depth] += i;
            makeConsultCombi(k, remaining - i, depth + 1);
            consultCombi[depth] -= i;
        }
    }
}