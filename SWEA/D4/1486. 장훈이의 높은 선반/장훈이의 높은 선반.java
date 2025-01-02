import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, b;
    static int[] arr;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tt = 1; tt <= t; tt++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            recursive(0, 0);
            sb.append("#").append(tt).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int sum) {
        if (sum >= b) {
            min = Math.min(min, sum - b);
            return;
        }
        if(depth == n)
            return;
        recursive(depth + 1, sum + arr[depth]);
        recursive(depth + 1, sum);
    }
}