import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] p1, p2;
    static boolean[] used;
    static int cnt1, cnt2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            p1 = new int[9];
            p2 = new int[9];
            used = new boolean[19];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                p1[i] = Integer.parseInt(st.nextToken());
                used[p1[i]] = true;
            }
            int idx = 0;
            for (int i = 1; i <= 18; i++)
                if (!used[i])
                    p2[idx++] = i;
            cnt1 = 0;
            cnt2 = 0;
            recursive(0, 0, 0, 0);
            sb.append("#").append(tc).append(" ").append(cnt1).append(" ").append(cnt2).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int visited, int s1, int s2) {
        if (depth == 9) {
            if (s1 > s2)
                cnt1++;
            else
                cnt2++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if ((visited & 1 << i) == 0) {
                int ns1 = s1, ns2 = s2;
                if (p1[depth] > p2[i])
                    ns1 += p1[depth] + p2[i];
                else
                    ns2 += p1[depth] + p2[i];
                recursive(depth + 1, visited | 1 << i, ns1, ns2);
            }
        }
    }
}