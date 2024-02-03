import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[] amount = new int[land[0].length];
        boolean[][] chk = new boolean[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (!chk[j][i] && land[j][i] != 0) {
                    bfs(chk, land, amount, new int[] {j, i});
                }
            }
        }
        for (int i : amount) {
            answer = Math.max(answer, i);
        }
        return answer;
    }

    public void bfs(boolean[][] chk, int[][] land, int[] amount, int[] p) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> pQue = new ArrayDeque<>();
        int count = 0;
        chk[p[0]][p[1]] = true;
        pQue.add(p.clone());
        HashSet<Integer> line = new HashSet<>();
        while (!pQue.isEmpty()) {
            int[] area = pQue.poll();
            count++;
            line.add(area[1]);
            for (int i = 0; i < 4; i++) {
                int x = area[1] + dx[i];
                int y = area[0] + dy[i];
                if (0 <= x && x < land[0].length && 0 <= y && y < land.length) {
                    if (!chk[y][x] && land[y][x] != 0) {
                        chk[y][x] = true;
                        pQue.add(new int[] {y, x});
                    }
                }
            }
        }
        for (Integer i : line) {
            amount[i] += count;
        }
    }
}