class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            int x = balls[i][0];
            int y = balls[i][1];
            int[][] moves = {{x, -y}, {x, n + (n - y)}, {-x, y}, {m + (m - x), y}};
            for (int j = 0; j < 4; j++) {
                int[] move = moves[j];
                if (chk(startX, startY, balls[i], j)) {
                    continue;
                }
                int tmp = (int) (Math.pow(startX - move[0], 2) + Math.pow(startY - move[1], 2));
                min = Math.min(min, tmp);
            }
            answer[i] = min;
        }
        return answer;
    }

    public boolean chk(int startX, int startY, int[] ball, int j) {
        switch (j) {
            case 0:
                if (startX == ball[0] && startY > ball[1]) {
                    return true;
                }
                break;
            case 1:
                if (startX == ball[0] && startY < ball[1]) {
                    return true;
                }
                break;
            case 2:
                if (startY == ball[1] && startX > ball[0]) {
                    return true;
                }
                break;
            case 3:
                if (startY == ball[1] && startX < ball[0]) {
                    return true;
                }
                break;
        }
        return false;
    }
}