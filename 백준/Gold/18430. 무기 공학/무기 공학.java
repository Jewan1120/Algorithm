public class Main {

    static int n, m, maxValue = 0;
    static int[] board;
    static int[] dir;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        dir = new int[] { -m, 1, m, -1 };
        board = new int[n * m];
        for (int i = 0; i < n * m; i++)
            board[i] = read();
        recursive(0, 0, new boolean[n * m]);
        System.out.println(maxValue);
    }

    private static void recursive(int cur, int sumValue, boolean[] visited) {
        maxValue = Math.max(maxValue, sumValue);
        for (int i = cur; i < n * m; i++) {
            if (!visited[i])
                for (int j = 0; j < 4; j++) {
                    int next1 = i + dir[j];
                    int next2 = i + dir[(j + 1) % 4];
                    if (isPossible(i, next1, next2, visited)) {
                        visited[i] = visited[next1] = visited[next2] = true;
                        int value = board[i] * 2 + board[next1] + board[next2];
                        recursive(i + 1, sumValue + value, visited);
                        visited[i] = visited[next1] = visited[next2] = false;
                    }
                }
        }
    }

    private static boolean isPossible(int idx, int idx1, int idx2, boolean[] visited) {
        return isValid(idx, idx1) && isValid(idx, idx2) && !visited[idx1] && !visited[idx2];
    }

    private static boolean isValid(int cur, int next) {
        if (next < 0 || next >= n * m)
            return false;
        if (Math.abs(cur % m - next % m) > 1)
            return false;
        return true;
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