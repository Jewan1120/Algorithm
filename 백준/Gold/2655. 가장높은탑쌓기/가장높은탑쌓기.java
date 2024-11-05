import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Brick {
        int num;
        int s;
        int h;
        int w;

        Brick(int num, int s, int h, int w) {
            this.num = num;
            this.s = s;
            this.h = h;
            this.w = w;
        }
    }

    static int N;
    static Brick[] list;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new Brick[N + 1];
        dp = new int[N + 1];

        Arrays.fill(dp, 0);
        list[0] = new Brick(0, 0, 0, 0);

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[i] = new Brick(i, s, h, w);
        }

        Arrays.sort(list, (o1, o2) -> o1.s - o2.s);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++)
                if (list[i].w > list[j].w)
                    dp[i] = Math.max(dp[i], dp[j] + list[i].h);
            max = Math.max(max, dp[i]);
        }

        Stack<Integer> stk = new Stack<>();
        while (N > 0) {
            if (max == dp[N]) {
                stk.add(list[N].num);
                max -= list[N].h;
            }
            N--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stk.size()).append("\n");
        while (!stk.isEmpty())
            sb.append(stk.pop()).append("\n");
        System.out.println(sb);
    }
}