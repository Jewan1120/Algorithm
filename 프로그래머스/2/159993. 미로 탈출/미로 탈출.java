import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[][] pathL = new int[maps.length][maps[0].length()];
        int[][] pathE = new int[maps.length][maps[0].length()];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] s = new int[2];
        int[] l = new int[2];
        int[] e = new int[2];
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains("S")) {
                s = new int[] {i, maps[i].indexOf('S')};
            }
            if (maps[i].contains("L")) {
                l = new int[] {i, maps[i].indexOf('L')};
            }
            if (maps[i].contains("E")) {
                e = new int[] {i, maps[i].indexOf('E')};
            }
        }
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(s);
        while (!deq.isEmpty()) {
            int[] p = deq.poll();
            int n = pathL[p[0]][p[1]] + 1;
            for (int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if (0 <= newY && newY < pathL.length && 0 <= newX && newX < pathL[0].length) {
                    if (maps[newY].charAt(newX) == 'X') {
                        continue;
                    }
                    if (pathL[newY][newX] == 0 || pathL[newY][newX] > n) {
                        pathL[newY][newX] = n;
                        deq.add(new int[] {newY, newX});
                    }
                }
            }
        }
        deq.add(l);
        while (!deq.isEmpty()) {
            int[] p = deq.poll();
            int n = pathE[p[0]][p[1]] + 1;
            for (int i = 0; i < 4; i++) {
                int newY = p[0] + dy[i];
                int newX = p[1] + dx[i];
                if (0 <= newY && newY < pathE.length && 0 <= newX && newX < pathE[0].length) {
                    if (maps[newY].charAt(newX) == 'X') {
                        continue;
                    }
                    if (pathE[newY][newX] == 0 || pathE[newY][newX] > n) {
                        pathE[newY][newX] = n;
                        deq.add(new int[] {newY, newX});
                    }
                }
            }
        }
        if (pathL[l[0]][l[1]] == 0 || pathE[e[0]][e[1]] == 0) {
            answer = -1;
        } else {
            answer = pathL[l[0]][l[1]] + pathE[e[0]][e[1]];
        }
        return answer;
    }
}