import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, s, u, v;
        ArrayList<ArrayList<Integer>> al;
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            al = new ArrayList<>();
            for (int i = 0; i < 101; i++)
                al.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i += 2) {
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                al.get(u).add(v);
            }
            int last = 0, size = 0;
            Deque<Integer> dq = new ArrayDeque<>();
            boolean[] visited = new boolean[101];
            visited[s] = true;
            dq.offer(s);
            while (!dq.isEmpty()) {
                last = 0;
                size = dq.size();
                while (size-- > 0) {
                    int cur = dq.poll();
                    last = Math.max(last, cur);
                    for (int next : al.get(cur)) {
                        if (!visited[next])
                            dq.offer(next);
                        visited[next] = true;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(last).append("\n");
        }
        System.out.println(sb);
    }
}
