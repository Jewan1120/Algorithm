import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Deque<String> dq = new ArrayDeque<>();
        dq.offer(begin);
        int cnt = 0;
        boolean[] visited = new boolean[words.length];
        while (!dq.isEmpty()) {
            int t = dq.size();
            while (t-- > 0) {
                String str = dq.poll();
                if (str.equals(target)) {
                    return cnt;
                }
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && isPossible(str, words[i])) {
                        visited[i] = true;
                        dq.offer(words[i]);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    
    private boolean isPossible(String A, String B) {
        int cnt = 0;
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) != B.charAt(i))
                cnt++;
        return cnt == 1;
    }
}