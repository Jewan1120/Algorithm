import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0, n = queue1.length;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < n; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            s1 += queue1[i];
            s2 += queue2[i];
        }
        while (s1 != s2) {
            if (s1 > s2) {
                int p = q1.pop();
                q2.offer(p);
                s1 -= p;
                s2 += p;
            } else if (s1 < s2) {
                int p = q2.pop();
                q1.offer(p);
                s2 -= p;
                s1 += p;
            }
            answer++;
            if (answer == n * 3)
                return -1;
        }
        return answer;
    }
}