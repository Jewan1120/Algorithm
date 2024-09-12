import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        if (works.length == 1)
            return (long) Math.pow(Math.max(0, works[0] - n), 2);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < works.length; i++)
            pq.offer(works[i]);
        while (n > 0) {
            int most = pq.poll();
            if (most == 0)
                return 0;
            int diff = most - pq.peek();
            if (diff == 0) {
                most--;
                n--;
            } else if (n < diff) {
                most -= n;
                n = 0;
            } else {
                most -= diff;
                n -= diff;
            }
            pq.offer(most);
        }
        for (int i = 0; i < works.length; i++)
            answer += (long) Math.pow(pq.poll(), 2);
        return answer;
    }
}