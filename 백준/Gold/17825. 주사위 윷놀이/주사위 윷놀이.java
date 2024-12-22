import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> routes = new ArrayList<>();

    static int[] moves = new int[10];
    static int[] turns = new int[10];
    static int[][] horses;
    static int maxScore = 0;

    static {
        for (int i = 0; i < 4; i++) {
            routes.add(new ArrayList<>());
        }
        for (int i = 0; i <= 40; i += 2) {
            routes.get(0).add(i);
        }
        for (int i = 0; i <= 15; i++) {
            if (i <= 5) {
                routes.get(1).add(routes.get(0).get(i));
                routes.get(2).add(routes.get(0).get(i));
                routes.get(3).add(routes.get(0).get(i));
            } else if (i <= 10) {
                routes.get(2).add(routes.get(0).get(i));
                routes.get(3).add(routes.get(0).get(i));
            } else {
                routes.get(3).add(routes.get(0).get(i));
            }
        }
        routes.get(1).add(13);
        routes.get(1).add(16);
        routes.get(1).add(19);
        routes.get(2).add(22);
        routes.get(2).add(24);
        routes.get(3).add(28);
        routes.get(3).add(27);
        routes.get(3).add(26);
        for (int i = 25; i <= 40; i += 5) {
            routes.get(1).add(i);
            routes.get(2).add(i);
            routes.get(3).add(i);
        }
        routes.get(0).add(0);
        routes.get(1).add(0);
        routes.get(2).add(0);
        routes.get(3).add(0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++)
            moves[i] = Integer.parseInt(st.nextToken());
        recursive(0);
        System.out.println(maxScore);
    }

    private static void recursive(int depth) {
        if (depth == 10) {
            move();
            return;
        }
        for (int i = 0; i < 4; i++) {
            turns[depth] = i;
            recursive(depth + 1);
        }
    }

    private static void move() {
        int score = 0;
        horses = new int[4][2];
        for (int i = 0; i < 10; i++) {
            int turn = turns[i];
            horses[turn][1] += moves[i];
            if (horses[turn][1] >= routes.get(horses[turn][0]).size())
                horses[turn][1] = routes.get(horses[turn][0]).size() - 1;
            if (horses[turn][0] == 0 && (horses[turn][1] == 5 || horses[turn][1] == 10 || horses[turn][1] == 15)) {
                horses[turn][0] = horses[turn][1] / 5;
            }
            if (!isPossible(turn))
                return;
            int route = horses[turn][0];
            int pos = horses[turn][1];
            score += routes.get(route).get(pos);
        }
        maxScore = Math.max(maxScore, score);
    }

    private static boolean isPossible(int turn) {
        for (int i = 0; i < 4; i++) {
            if (i == turn)
                continue;
            if (horses[turn][0] == horses[i][0])
                if (horses[turn][1] != routes.get(horses[turn][0]).size() - 1 && horses[turn][1] == horses[i][1])
                    return false;
            int A = routes.get(horses[turn][0]).get(horses[turn][1]);
            int B = routes.get(horses[i][0]).get(horses[i][1]);
            if (A == B)
                if (A == 25 || A == 35 || A == 40)
                    return false;
                else if(A == 30 && routes.get(horses[turn][0]) == routes.get(horses[i][0]))
                    return false;
        }
        return true;
    }
}