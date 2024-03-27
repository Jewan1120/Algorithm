class Solution {
    public long solution(int[] sequence) {
        long[] maxSum = {Long.MIN_VALUE, Long.MIN_VALUE};
        long[] currentSum = {0, 0};
        int[] pulse = {1, -1};
        for (int i = 0; i < sequence.length; i++) {
            int p = sequence[i] * pulse[i % 2];
            currentSum[0] = Math.max(p, currentSum[0] + p);
            currentSum[1] = Math.max(-p, currentSum[1] - p);
            maxSum[0] = Math.max(maxSum[0], currentSum[0]);
            maxSum[1] = Math.max(maxSum[1], currentSum[1]);
        }
        return Math.max(maxSum[0], maxSum[1]);
    }
}