import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int round = 0;
        int len = enemy.length;
        for (; round < len; round++) {
            pq.offer(enemy[round]);
            if (n < enemy[round]) {
                if (0 == k)
                    break;
                n += pq.poll();
                k--;
            }
            n -= enemy[round];
        }
        return round;
    }
}