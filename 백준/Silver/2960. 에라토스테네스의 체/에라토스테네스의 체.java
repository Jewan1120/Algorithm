import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] chkArr = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            dq.offer(i);
        while (!dq.isEmpty()) {
            int p = dq.poll();
            for (int i = p; i <= n; i += p) {
                if (!chkArr[i]) {
                    k--;
                    if (k == 0) {
                        System.out.println(i);
                        return;
                    }
                    chkArr[i] = true;
                }
            }
        }
    }
}