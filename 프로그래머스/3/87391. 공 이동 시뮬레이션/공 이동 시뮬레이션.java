class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long x1 = x, x2 = x, y1 = y, y2 = y;
        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            int dx = queries[i][1];
            if (command == 0) {
                if (y1 != 0)
                    y1 += dx;
                y2 = Math.min(m - 1, y2 + dx);
            } else if (command == 1) {
                if (y2 != m - 1)
                    y2 -= dx;
                y1 = Math.max(0, y1 - dx);
            } else if (command == 2) {
                if (x1 != 0)
                    x1 += dx;
                x2 = Math.min(n - 1, x2 + dx);
            } else if (command == 3) {
                if (x2 != n - 1)
                    x2 -= dx;
                x1 = Math.max(0, x1 - dx);
            }
            if (x1 > x2 || y1 > y2)
                return 0;
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}