import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        ArrayList<PriorityQueue<int[]>> al = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            al.add(new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o1[0] - o2[0]));
        }
        for (int i = 0; i < n; i++) {
            int p = read();
            for (int j = 0; j < 4; j++) {
                al.get(j).add(new int[] { p, read() });
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < 4; i++) {
            PriorityQueue<int[]> pq = al.get(i);
            int p;
            while (visited[(p = pq.poll()[0])]) { }
            visited[p] = true;
            sb.append(p).append(" ");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}