import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int y = maps.length;
        int x = maps[0].length();
        boolean[][] check = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            char[] map = maps[i].toCharArray();
            for (int j = 0; j < x; j++) {
                if (Character.isDigit(map[j]) && !check[i][j]) {
                    int sum = 0;
                    Queue<int[]> que = new LinkedList<int[]>();
                    que.add(new int[] {i, j});
                    while (!que.isEmpty()) {
                        int[] point = que.poll();
                        if (check[point[0]][point[1]]) continue;
                        sum += maps[point[0]].charAt(point[1]) - '0';
                        check[point[0]][point[1]] = true;
                        for (int k = 0; k < 4; k++) {
                            int newY = point[0] + dy[k];
                            int newX = point[1] + dx[k];
                            if ((0 <= newY && newY < y) && (0 <= newX && newX < x)) {
                                char tmpChar = maps[newY].charAt(newX);
                                if (Character.isDigit(tmpChar) && !check[newY][newX]) {
                                    que.add(new int[] {newY, newX});
                                }
                            }
                        }
                    }
                    if (answer.length == 0) {
                        answer = new int[] {sum};
                    } else {
                        int[] tmp = new int[answer.length + 1];
                        System.arraycopy(answer, 0, tmp, 0, answer.length);
                        tmp[answer.length] = sum;
                        answer = tmp;
                    }
                }
            }
        }
        if (answer.length == 0) {
            answer = new int[] {-1};
        }
        Arrays.sort(answer);
        return answer;
    }
}