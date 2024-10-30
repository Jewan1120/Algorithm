class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0, pickup = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            while (deliveries[i] > delivery || pickups[i] > pickup) {
                cnt++;
                delivery += cap;
                pickup += cap;
            }
            delivery -= deliveries[i];
            pickup -= pickups[i];
            answer += (i + 1) * 2 * cnt;
        }
        return answer;
    }
}