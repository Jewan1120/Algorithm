class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryOverLoad = 0;
        int pickUpOverLoad = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            if (deliveries[i] > 0 || pickups[i] > 0) {
                deliveries[i] -= deliveryOverLoad;
                pickups[i] -= pickUpOverLoad;
                while (deliveries[i] > 0 || pickups[i] > 0) {
                    cnt++;
                    deliveries[i] -= cap;
                    pickups[i] -= cap;
                }
                deliveryOverLoad = -(deliveries[i]);
                pickUpOverLoad = -(pickups[i]);
                deliveries[i] = 0;
                pickups[i] = 0;

            }
            answer += (i + 1) * 2 * cnt;
        }
        return answer;
    }
}