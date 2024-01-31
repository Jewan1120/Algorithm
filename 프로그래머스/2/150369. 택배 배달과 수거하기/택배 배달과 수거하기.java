class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deli = 0;
        int pick = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (deliveries[i] > deli || pickups[i] > pick) {
                    cnt++;
                    deli += cap;
                    pick += cap;
                }
                deli -= deliveries[i];
                pick -= pickups[i];
                answer += (i + 1) * 2 * cnt;
            }
        }
        return answer;
    }
}