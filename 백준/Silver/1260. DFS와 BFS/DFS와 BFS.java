import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (; m > 0; m--) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        for (int i = 0; i <= n; i++) {
            graph.get(i).sort((o1, o2) -> o2 - o1);
        }
        dfs(graph, s, new boolean[n + 1]);
        for (int i = 0; i <= n; i++) {
            graph.get(i).sort((o1, o2) -> o1 - o2);
        }
        bfs(graph, s, new boolean[n + 1]);
        System.out.println();
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited) {
        Stack<Integer> stk = new Stack<>();
        stk.push(s);
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            int cur = stk.pop();
            if (visited[cur])
                continue;
            visited[cur] = true;
            sb.append(cur).append(" ");
            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    stk.push(i);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited) {
        Deque<Integer> deq = new ArrayDeque<>();
        deq.add(s);
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            int cur = deq.poll();
            if (visited[cur])
                continue;
            visited[cur] = true;
            sb.append(cur).append(" ");
            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    deq.add(i);
                }
            }
        }
        System.out.println(sb.toString());
    }
}