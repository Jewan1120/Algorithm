class Solution {
    int n, m;

    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < (1 << m); j++) {
                if (isPossible(beginning, target, i, j)) {
                    int cnt = Integer.bitCount(i) + Integer.bitCount(j);
                    min = Math.min(min, cnt);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isPossible(int[][] beginning, int[][] target, int row, int col) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int v = beginning[i][j];
                if (((1 << i) & row) != 0) {
                    v ^= 1;
                }
                if (((1 << j) & col) != 0) {
                    v ^= 1;
                }
                if (target[i][j] != v)
                    return false;
            }
        return true;
    }
}