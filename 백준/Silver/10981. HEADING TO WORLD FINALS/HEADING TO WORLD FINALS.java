import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    static class Team {
        String u, n;
        int s, p;
        public Team(String u, String n, int s, int p) {
            this.u = u;
            this.n = n;
            this.s = s;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        PriorityQueue<Team> pq = new PriorityQueue<>((o1, o2) -> o1.s == o2.s ? o1.p - o2.p : o2.s - o1.s);
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Team(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        while (k > 0) {
            Team team = pq.poll();
            if (!hs.contains(team.u)) {
                sb.append(team.n).append("\n");
                hs.add(team.u);
                k--;
            }
        }
        System.out.println(sb);
    }
}