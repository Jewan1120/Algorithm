import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder("<");
        while (!que.isEmpty()) {
            int i = que.poll();
            cnt++;
            if (cnt == k) {
                sb.append(i).append(", ");
                cnt = 0;
            } else {
                que.offer(i);
            }
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.println(sb.toString());
    }
}