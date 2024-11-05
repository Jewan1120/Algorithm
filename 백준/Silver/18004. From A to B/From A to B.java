import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b));
    }

    private static int solve(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        if (a <= b) {
            return b - a;
        }
        q.add(new int[] { 0, a });
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cost = current[0];
            int now = current[1];
            if (now == b) {
                return cost;
            }
            if (now > b) {
                if (now % 2 == 0) {
                    q.add(new int[] { cost + 1, now / 2 });
                } else {
                    q.add(new int[] { cost + 1, now + 1 });
                }
            } else {
                return cost + (b - now);
            }
        }
        return -1;
    }
}