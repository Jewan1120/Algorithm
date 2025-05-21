public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), m = read(), r = read(), c = read();
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				board[i][j] = read();
		int[][] plan = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				plan[i][j] = read();
		int cnt = 0;
		for (int i = 0; i <= n - r; i++)
			loop : for (int j = 0; j <= m - c; j++) {
				int condition = board[i][j] - plan[0][0];
				for (int k = 0; k < r; k++)
					for (int l = 0; l < c; l++)
						if (board[i + k][j + l] - plan[k][l] != condition)
							continue loop;
				cnt++;
			}
		System.out.println(cnt);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}	