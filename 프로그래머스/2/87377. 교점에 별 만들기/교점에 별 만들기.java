import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public String[] solution(int[][] line) {
        ArrayList<long[]> dots = new ArrayList<>();
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];
                long dir = a * d - b * c;
                if (dir == 0) {
                    continue;
                }
                long x = b * f - e * d;
                long y = e * c - a * f;
                if (x % dir == 0 && y % dir == 0) {
                    long[] p = { x / dir, y / dir };
                    dots.add(p);
                    if (p[1] < minY) {
                        minY = p[1];
                    }
                    if (maxY < p[1]) {
                        maxY = p[1];
                    }
                    if (p[0] < minX) {
                        minX = p[0];
                    }
                    if (maxX < p[0]) {
                        maxX = p[0];
                    }
                }
            }
        }
        int height = (int) (maxY - minY + 1);
        int width = (int) (maxX - minX + 1);
        char[][] board = new char[height][width];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        for (long[] dot : dots) {
            int x = (int) (dot[0] - minX);
            int y = (int) (dot[1] - minY);
            board[y][x] = '*';
        }
        String[] answer = new String[height];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(board[board.length - i - 1]);
        }
        return answer;
    }
}