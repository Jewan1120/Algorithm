import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static int n;
	static boolean[][] board;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];
		ArrayList<int[]> bArr = new ArrayList<>(3);
		ArrayList<int[]> eArr = new ArrayList<>(3);
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = line.charAt(j);
				if (c == '1')
					board[i][j] = true;
				else if (c == 'B')
					bArr.add(new int[] { i, j });
				else if (c == 'E')
					eArr.add(new int[] { i, j });
			}
		}
		int[] sB = getInfo(bArr);
		int[] sE = getInfo(eArr);
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][n][n];
		dq.offer(sB);
		visited[sB[2]][sB[0]][sB[1]] = true;
		int time = 0;
		while (!dq.isEmpty()) {
			int size = dq.size();
			while (size-- > 0) {
				int[] cur = dq.poll();
				int y = cur[0], x = cur[1], t = cur[2];
				if (y == sE[0] && x == sE[1] && t == sE[2]) {
					System.out.println(time);
					return;
				}
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i], nx = x + dx[i];
					if (canMove(ny, nx, t) && !visited[t][ny][nx]) {
						dq.offer(new int[] { ny, nx, t });
						visited[t][ny][nx] = true;
					}
				}
				if (canRotate(y, x)) {
					int nt = t ^ 1;
					if (!visited[nt][y][x]) {
						dq.offer(new int[] { y, x, nt });
						visited[nt][y][x] = true;
					}
				}
			}
			time++;
		}
		System.out.println(0);
	}

	private static int[] getInfo(ArrayList<int[]> arr) {
		int[] info = new int[3];
		info[0] = arr.get(1)[0];
		info[1] = arr.get(1)[1];
		info[2] = arr.get(1)[0] - arr.get(0)[0] == 0 ? 0 : 1;
		return info;
	}

	private static boolean canRotate(int my, int mx) {
		int sy = my - 1, sx = mx - 1;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				int ny = sy + i, nx = sx + j;
				if (!isValid(ny, nx) || board[ny][nx])
					return false;
			}
		return true;
	}

	private static boolean canMove(int my, int mx, int t) {
		if (!isValid(my, mx, t))
			return false;
		if (t == 0) {
			if (board[my][mx - 1] || board[my][mx] || board[my][mx + 1])
				return false;
		} else {
			if (board[my - 1][mx] || board[my][mx] || board[my + 1][mx])
				return false;
		}
		return true;
	}

	private static boolean isValid(int my, int mx, int t) {
		if (t == 0) {
			if (!isValid(my, mx - 1) || !isValid(my, mx) || !isValid(my, mx + 1))
				return false;
		} else {
			if (!isValid(my - 1, mx) || !isValid(my, mx) || !isValid(my + 1, mx))
				return false;
		}
		return true;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}
