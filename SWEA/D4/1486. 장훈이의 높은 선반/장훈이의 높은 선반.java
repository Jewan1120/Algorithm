import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, b;
        TreeSet<Integer> ts;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ts = new TreeSet<>();
            ts.add(0);
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                for (int u : new ArrayList<>(ts))
                    ts.add(u + v);
            }
            sb.append("#").append(tc).append(" ").append(ts.ceiling(b) - b).append("\n");
        }
        System.out.println(sb);
    }
}