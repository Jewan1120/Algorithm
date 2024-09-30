import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        int[] x = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            p[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            x[i] = Integer.parseInt(st.nextToken());
        int cur = p[0] + x[0];
        int cnt = 0, idx = 1;
        while (cur < m) {
            int next = cur;
            while (idx < n && p[idx] <= cur) {
                next = Math.max(next, p[idx] + x[idx]);
                idx++;
            }
            if (next == cur) {
                System.out.println(-1);
                return;
            }
            cur = next;
            cnt++;
        }
        System.out.println(cnt);
    }
}