import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static int n, m;
    static char[][] board;
    static boolean[] visited;
    static boolean[] cycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n * m];
        cycle = new boolean[n * m];
        for (int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();
        for (int i = 0; i < n * m; i++)
            if (!visited[i])
                dfs(i);
        System.out.println(cnt);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        int next = move(cur);
        if (!visited[next]) {
            dfs(next);
        } else if (!cycle[next]) {
            cnt++;
        }
        cycle[cur] = true;
    }

    private static int move(int cur) {
        int next = cur;
        int y = cur / m, x = cur % m;
        char dir = board[y][x];
        if (dir == 'U')
            next -= m;
        else if (dir == 'D')
            next += m;
        else if (dir == 'L')
            next--;
        else
            next++;
        return next;
    }
}