import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            int k = Integer.parseInt(br.readLine());
            int[][] gear = new int[4][8];
            int[] top = new int[4];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++)
                    gear[i][j] = Integer.parseInt(st.nextToken());
            }
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()) - 1;
                int m = Integer.parseInt(st.nextToken());
                int[] d = new int[4];
                d[n] = m == 1 ? -1 : 1;
                for (int i = n; i > 0; i--) {
                    if (gear[i][(top[i] + 6) % 8] != gear[i - 1][(top[i - 1] + 2) % 8])
                        d[i - 1] = d[i] * -1;
                    else
                        break;
                }
                for (int i = n; i < 3; i++) {
                    if (gear[i][(top[i] + 2) % 8] != gear[i + 1][(top[i + 1] + 6) % 8])
                        d[i + 1] = d[i] * -1;
                    else
                        break;
                }
                for (int i = 0; i < 4; i++)
                    top[i] = (top[i] + d[i] + 8) % 8;
            }
            int result = 0;
            for (int i = 0; i < 4; i++)
                result += gear[i][top[i]] * Math.pow(2, i);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
