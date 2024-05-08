import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(a);
        dq.add(1);
        int min = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            int cnt = dq.poll();
            if (cur == b) {
                min = Math.min(min, cnt);
                continue;
            }
            if (cur < b) {
                dq.add(cur * 2);
                dq.add(cnt + 1);
            }
            if (cur < b / 10 + 1) {
                dq.add(cur * 10 + 1);
                dq.add(cnt + 1);
            }
        }
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
        br.close();
    }
}