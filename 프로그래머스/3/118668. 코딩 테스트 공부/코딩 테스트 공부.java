class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp, maxCop = cop;
        for (int i = 0; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i < maxAlp)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if (j < maxCop)
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                for (int[] problem : problems)
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextAlp = Math.min(maxAlp, i + problem[2]);
                        int nextCop = Math.min(maxCop, j + problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
            }
        }
        return dp[maxAlp][maxCop];
    }
}