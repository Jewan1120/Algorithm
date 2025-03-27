import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int[] parents, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1;
        StringTokenizer st2;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            double[][] nodes = new double[n][2];
            parents = new int[n];
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                double x = Double.parseDouble(st1.nextToken());
                double y = Double.parseDouble(st2.nextToken());
                nodes[i] = new double[] { x, y };
            }
            double e = Double.parseDouble(br.readLine());
            double[][] costs = new double[n][n];
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++) {
                    double cost = e * (Math.pow(nodes[i][0] - nodes[j][0], 2) + Math.pow(nodes[i][1] - nodes[j][1], 2));
                    costs[i][j] = cost;
                    costs[j][i] = cost;
                }
            PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1[1], o2[1]));
            pq.offer(new double[] { 0, 0 });
            boolean[] isMst = new boolean[n];
            int cnt = 0;
            double totalCost = 0;
            while (!pq.isEmpty() && cnt < n) {
                double[] cur = pq.poll();
                int idx = (int) cur[0];
                if (isMst[idx])
                    continue;
                isMst[idx] = true;
                totalCost += cur[1];
                cnt++;
                for (int i = 0; i < n; i++) {
                    if (!isMst[i]) {
                        pq.offer(new double[] { i, costs[idx][i] });
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(Math.round(totalCost)).append("\n");
        }
        System.out.println(sb);
    }
}
