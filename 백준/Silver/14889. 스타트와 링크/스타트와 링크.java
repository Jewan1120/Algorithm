public class Main {
    static int n;
    static int[][] status;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        n = read();
        status = new int[n][n];
        team = new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                status[i][j] = read();
        match(0, 0);
        System.out.println(min);
    }
    private static void match(int cnt, int idx) {
        if (cnt == n / 2) {
            int scoreA = 0, scoreB = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    if (team[i] && team[j]) scoreA += status[i][j];
                    else if (!team[i] && !team[j]) scoreB += status[i][j];
                }
            }
            min = Math.min(min, Math.abs(scoreA - scoreB));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!team[i]) {
                team[i] = true;
                match(cnt + 1, i + 1);
                team[i] = false;
            }
        }
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}