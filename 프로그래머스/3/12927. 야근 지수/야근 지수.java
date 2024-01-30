import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int w : works) {
            pq.add(w);
        }
        while (n > 0) {
            if (pq.peek() == 0) {
                break;
            }
            pq.add(pq.poll() - 1);
            n--;
        }
        for (Integer i : pq) {
            answer += Math.pow(i, 2);
        }
        return answer;
    }
}