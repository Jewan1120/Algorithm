import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int l = 1, r = distance;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(distance, rocks, m, n)) {
                l = m + 1;
            } else
                r = m - 1;
        }
        return r;
    }
    
    private boolean isPossible(int distance, int[] rocks, int target, int n) {
        int now = 0;
        int removed = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] < now + target)
                removed++;
            else
                now = rocks[i];
        }
        if (distance < now + target)
            removed++;
        return removed <= n;
    }
}