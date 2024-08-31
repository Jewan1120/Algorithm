import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Room {
        char type;
        int money;
        ArrayList<Integer> to;

        Room(char type, int money, ArrayList<Integer> to) {
            this.type = type;
            this.money = money;
            this.to = to;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            Room[] rooms = new Room[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);
                int money = Integer.parseInt(st.nextToken());
                ArrayList<Integer> to = new ArrayList<>();
                int p;
                while ((p = Integer.parseInt(st.nextToken())) != 0) {
                    to.add(p);
                }
                rooms[i] = new Room(type, money, to);
            }
            boolean possible = false;
            int[] visited = new int[n + 1];
            Arrays.fill(visited, -1);
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] { 1, 0 });
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                Room room = rooms[cur[0]];
                int curMoney = cur[1];
                if (room.type == 'T' && curMoney < room.money)
                    continue;
                if (room.type == 'T')
                    curMoney -= room.money;
                if (room.type == 'L')
                    curMoney = Math.max(curMoney, room.money);
                visited[cur[0]] = curMoney;
                if (cur[0] == n) {
                    possible = true;
                    break;
                }
                for (int next : room.to)
                    if (curMoney > visited[next])
                        dq.offer(new int[] { next, curMoney });
            }
            sb.append(possible ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }
}