import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int maxHeight = 0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] trees = new int[n];
            int total = 0, even = 0, odd = 0;
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            for (int i = 0; i < n; i++) {
                int needs = maxHeight - trees[i];
                even += needs / 2;
                odd += needs % 2;
            }
            while (even - odd > 1) {
                even--;
                odd += 2;
            }
            if (odd > even)
                total = odd * 2 - 1;
            else if (even > odd)
                total = even * 2;
            else
                total = odd + even;

            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }
}