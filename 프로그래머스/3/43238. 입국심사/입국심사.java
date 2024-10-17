import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 1, r = (long) times[times.length - 1] * n;
        while (l <= r) {
            long m = (l + r) / 2;
            if (isPossible(times, n, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean isPossible(int[] times, int n, long target) {
        long cnt = 0;
        for (int time : times) {
            cnt += target / (long) time;
        }
        return cnt >= n;
    }
}