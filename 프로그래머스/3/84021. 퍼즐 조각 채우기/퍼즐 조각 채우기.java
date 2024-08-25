import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
class Solution {
    ArrayList<ArrayList<int[]>> boards = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<int[]>>> blocks = new ArrayList<>();
    int len;
    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, 1, -1 };

    public int solution(int[][] game_board, int[][] table) {
        len = game_board.length;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (game_board[i][j] == 0) {
                    ArrayList<int[]> board = bfs(game_board, i, j, 0);
                    normalize(board);
                    boards.add(board);
                }
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (table[i][j] == 1) {
                    ArrayList<int[]> origin = bfs(table, i, j, 1);
                    blocks.add(rotate(origin));
                }
        boolean[] visited = new boolean[blocks.size()];
        int answer = 0;
        for (int i = 0; i < boards.size(); i++) {
            for (int j = 0; j < blocks.size(); j++) {
                if (!visited[j] && isPossible(i, j)) {
                    visited[j] = true;
                    answer += boards.get(i).size();
                    break;
                }
            }
        }
        return answer;
    }

    private ArrayList<int[]> bfs(int[][] target, int y, int x, int num) {
        ArrayList<int[]> result = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { y, x });
        int visited = num == 0 ? 1 : 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (target[cur[0]][cur[1]] == visited)
                continue;
            target[cur[0]][cur[1]] = visited;
            result.add(new int[] { cur[0] - y, cur[1] - x });
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (isValid(ny, nx) && target[ny][nx] == num)
                    dq.offer(new int[] { ny, nx });
            }
        }
        return result;
    }

    private ArrayList<ArrayList<int[]>> rotate(ArrayList<int[]> origin) {
        ArrayList<ArrayList<int[]>> block = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            block.add(new ArrayList<>());
        for (int i = 0; i < origin.size(); i++) {
            int y = origin.get(i)[0];
            int x = origin.get(i)[1];
            block.get(0).add(new int[] { y, x });
            block.get(1).add(new int[] { -x, y });
            block.get(2).add(new int[] { -y, -x });
            block.get(3).add(new int[] { x, -y });
        }
        for (int i = 0; i < 4; i++)
            normalize(block.get(i));
        return block;
    }

    private void normalize(ArrayList<int[]> target) {
        int minY = 10, minX = 10;
        for (int[] arr : target) {
            minY = Math.min(minY, arr[0]);
            minX = Math.min(minX, arr[1]);
        }
        for (int[] arr : target) {
            arr[0] -= minY;
            arr[1] -= minX;
        }
        target.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
    }

    private boolean isValid(int y, int x) {
        return 0 <= y && y < len && 0 <= x && x < len;
    }

    private boolean isPossible(int boardIdx, int blockIdx) {
        ArrayList<int[]> board = boards.get(boardIdx);
        if (board.size() != blocks.get(blockIdx).get(0).size())
            return false;
        for (int i = 0; i < board.size(); i++) {
            next: for (ArrayList<int[]> block : blocks.get(blockIdx)) {
                for (int j = 0; j < block.size(); j++) {
                    if (board.get(j)[0] != block.get(j)[0] || board.get(j)[1] != block.get(j)[1]) {
                        continue next;
                    }
                }
                return true;
            }
        }
        return false;
    }
}