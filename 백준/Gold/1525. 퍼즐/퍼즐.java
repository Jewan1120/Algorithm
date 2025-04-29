import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Main {

	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		int[][] board = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = read();
		Deque<int[][]> dq = new ArrayDeque<>();
		HashSet<String> hs = new HashSet<>();
		dq.offer(board);
		int time = 0;
		while (!dq.isEmpty()) {
			int size = dq.size();
			while (size-- > 0) {
				int[][] cur = dq.poll();
				String curStr = intArrToString(cur);
				if (hs.contains(curStr))
					continue;
				hs.add(curStr);
				if (curStr.equals("123456780")) {
					System.out.println(time);
					return;
				}
				for (int y = 0; y < 3; y++)
					for (int x = 0; x < 3; x++)
						if (cur[y][x] == 0)
							for (int k = 0; k < 4; k++) {
								int ny = y + dy[k], nx = x + dx[k];
								if (!isValid(ny, nx))
									continue;
								int[][] next = copy(cur);
								swap(next, y, x, ny, nx);
								dq.offer(next);
							}
			}
			time++;
		}
		System.out.println(-1);
	}

	private static void swap(int[][] board, int y, int x, int ny, int nx) {
		int temp = board[y][x];
		board[y][x] = board[ny][nx];
		board[ny][nx] = temp;
	}

	private static int[][] copy(int[][] board) {
		int[][] newBoard = new int[3][3];
		for (int i = 0; i < 3; i++)
			newBoard[i] = board[i].clone();
		return newBoard;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < 3 && 0 <= x && x < 3;
	}

	private static String intArrToString(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				sb.append(board[i][j]);
		return sb.toString();
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = n << 3 + n << 1 + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}