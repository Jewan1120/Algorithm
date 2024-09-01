import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[9][9];
        for (int i = 0; i < 9; i++)
            board[i] = br.readLine().split(" ");
        TreeSet<String> ts = new TreeSet<>();
        TreeMap<String, TreeSet<String>> tm = new TreeMap<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;
                ts.add(board[3 + i][3 + j]);
                tm.put(board[i * 3 + 1][j * 3 + 1], new TreeSet<>());
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++) {
                        if (k == 1 && l == 1)
                            continue;
                        tm.get(board[i * 3 + 1][j * 3 + 1]).add(board[i * 3 + k][j * 3 + l]);
                    }
            }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (String goal : ts) {
            sb.append("#").append(++idx).append(". ").append(goal).append("\n");
            int subIdx = 0;
            for (String todo : tm.get(goal)) {
                sb.append("#").append(idx).append("-").append(++subIdx).append(". ").append(todo).append("\n");
            }
        }
        System.out.println(sb);
    }
}