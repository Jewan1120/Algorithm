import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int idx;
        Double score;

        Node(int idx, Double score) {
            this.idx = idx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(br.readLine()) * 0.05;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.score.compareTo(o1.score));
        int[] result = new int[26];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            double score = Double.parseDouble(st.nextToken());
            if (score >= x) {
                result[idx] = 0;
                for (int j = 1; j <= 14; j++)
                    pq.offer(new Node(idx, score / j));
            }
        }
        for (int i = 0; i < 14; i++)
            result[pq.poll().idx]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++)
            if (result[i] != -1)
                sb.append((char) ('A' + i)).append(" ").append(result[i]).append("\n");
        System.out.println(sb);
    }
}