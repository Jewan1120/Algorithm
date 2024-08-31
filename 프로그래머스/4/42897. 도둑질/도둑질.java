class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 2];
        for (int i = 0; i < n - 1; i++)
            dp1[i + 2] = Math.max(dp1[i + 1], dp1[i] + money[i]);
        for (int i = 1; i < n; i++)
            dp2[i + 2] = Math.max(dp2[i + 1], dp2[i] + money[i]);
        return Math.max(dp1[n], dp2[n + 1]);
    }
}