import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        char[] dirArr = {'U', 'D', 'L', 'R'};
        char[][] board = new char[height][];
        boolean[][][] visit = new boolean[height][width][4];
        for (int i = 0; i < height; i++) {
            board[i] = grid[i].toCharArray();
        }
        HashMap<Character, Integer> dirMap = new HashMap<>();
        for (int i = 0; i < dirArr.length; i++) {
            dirMap.put(dirArr[i], i);
        }
        ArrayList<Integer> lengthArr = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 4; k++) {
                    int y = i, x = j;
                    char dir = dirArr[k];
                    int mode = dirMap.get(dir);
                    int length = 0;
                    while (!visit[y][x][mode]) {
                        visit[y][x][mode] = true;
                        dir = nextDir(board, dir, y, x);
                        mode = dirMap.get(dir);
                        y += dy[mode];
                        x += dx[mode];
                        if (y == -1) {
                            y = height - 1;
                        } else if (y == height) {
                            y = 0;
                        }
                        if (x == -1) {
                            x = width - 1;
                        } else if (x == width) {
                            x = 0;
                        }
                        length++;
                    }
                    if (length > 0) {
                        lengthArr.add(length);
                    }
                }
            }
        }
        lengthArr.sort((o1, o2) -> o1 - o2);
        int[] answer = new int[lengthArr.size()];
        for (int i = 0; i < lengthArr.size(); i++) {
            answer[i] = lengthArr.get(i);
        }
        return answer;
    }

    public char nextDir(char[][] board, char dir, int y, int x) {
        char turn = board[y][x];
        if (turn != 'S') {
            if ((dir == 'L' && turn == 'R') || (dir == 'R' && turn == 'L')) {
                return 'U';
            } else if ((dir == 'L' && turn == 'L') || (dir == 'R' && turn == 'R')) {
                return 'D';
            } else if ((dir == 'U' && turn == 'L') || (dir == 'D' && turn == 'R')) {
                return 'L';
            } else if ((dir == 'U' && turn == 'R') || (dir == 'D' && turn == 'L')) {
                return 'R';
            }
        }
        return dir;
    }
}