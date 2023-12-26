class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows + 1][columns + 1];
        int num = 0;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                board[i][j] = ++num;
            }
        }
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        int index = 0;
        for (int[] query : queries) {
            int min = board[query[0]][query[1]];
            int[] p = {query[0], query[1]};
            int dir = 0;
            int n = (query[3] + query[2] - query[1] - query[0]) * 2;
            int value = board[p[0]][p[1]];
            for (int i = 0; i < n; i++) {
                if (value < min) {
                    min = value;
                }
                if (query[3] < p[1] + x[dir] || p[1] + x[dir] < query[1] || p[0] + y[dir] > query[2]) {
                    dir++;
                }
                int tmp = board[p[0] += y[dir]][p[1] += x[dir]];
                board[p[0]][p[1]] = value;
                value = tmp;
            }
            answer[index++] = min;
        }
        return answer;
    }
}