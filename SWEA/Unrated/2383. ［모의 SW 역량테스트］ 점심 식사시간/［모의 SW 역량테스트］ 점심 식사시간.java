import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static int minTime;
    static int[][] dist;
    static int[] costs, groups;
    static ArrayList<int[]> sArr, eArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sArr = new ArrayList<>();
            eArr = new ArrayList<>();
            costs = new int[2];
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int p = Integer.parseInt(st.nextToken());
                    if (p == 1)
                        sArr.add(new int[] { i, j });
                    else if (p > 1) {
                        costs[eArr.size()] = p;
                        eArr.add(new int[] { i, j });
                    }
                }
            }
            dist = new int[sArr.size()][2];
            for (int i = 0; i < sArr.size(); i++)
                for (int j = 0; j < eArr.size(); j++)
                    dist[i][j] = Math.abs(sArr.get(i)[0] - eArr.get(j)[0]) + Math.abs(sArr.get(i)[1] - eArr.get(j)[1]);
            groups = new int[sArr.size()];
            minTime = Integer.MAX_VALUE;
            recursive(0);
            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth) {
        if (depth == sArr.size()) {
            minTime = Math.min(minTime, calculate());
            return;
        }
        groups[depth] = 1;
        recursive(depth + 1);
        groups[depth] = 0;
        recursive(depth + 1);
    }

    private static int calculate() {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        for (int i = 0; i < sArr.size(); i++)
            al.get(groups[i]).add(dist[i][groups[i]]);
        Collections.sort(al.get(0));
        Collections.sort(al.get(1));
        int maxTime = 0;
        for (int i = 0; i < 2; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int cost = costs[i];
            int nowTime = 0;
            for (int time : al.get(i)) {
                while (!dq.isEmpty() && dq.peek() <= time)
                    dq.poll();
                if (dq.size() < 3)
                    dq.offer(time + cost + 1);
                else {
                    int nextTime = dq.poll();
                    if (nextTime > time)
                        dq.offer(nextTime + cost);
                    else {
                        dq.offer(time + cost + 1);
                    }
                }
            }
            while (!dq.isEmpty())
                nowTime = Math.max(nowTime, dq.poll());
            maxTime = Math.max(maxTime, nowTime);
        }
        return maxTime;
    }
}