import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l = 1, r = distance;
        while (l <= r) {
            int m = (l + r) / 2;
            int now = 0;
            int removed = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] < now + m)
                    removed++;
                else
                    now = rocks[i];
            }
            if (distance < now + m)
                removed++;
            if (removed <= n) {
                answer = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        return answer;
    }
}