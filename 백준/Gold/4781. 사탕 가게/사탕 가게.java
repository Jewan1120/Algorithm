import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, c, m, p;

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            while (true) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
                if (n == 0)
                    break;
                int[] dp = new int[m + 1];
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    c = Integer.parseInt(st.nextToken());
                    p = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
                    for (int j = p; j < m + 1; j++)
                        dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
                sb.append(dp[m]).append("\n");
            }
            System.out.println(sb);
        }
}