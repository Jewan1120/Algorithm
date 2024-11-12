import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int c;
    static boolean findFlag = false;
    static int[][] judgeArr;
    static int[] answer;
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        judgeArr = new int[c][2 + c];
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 + c; j++)
                judgeArr[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = new int[c];
        recurse(0);
        StringBuilder sb = new StringBuilder();
        for (int n : answer)
            sb.append(n).append(" ");
        System.out.println(sb);
    }

    private static void recurse(int depth) {
        if (depth == c) {
            if (judge()) {
                findFlag = true;
            }
            return;
        }
        for (int n = 1; n < 10; n++) {
            if (!visited[n]) {
                answer[depth] = n;
                visited[n] = true;
                recurse(depth + 1);
                if (findFlag)
                    return;
                visited[n] = false;
            }
        }
    }

    private static boolean judge() {
        for (int i = 0; i < c; i++) {
            int A = 0, B = 0;
            for (int j = 0; j < c; j++)
                for (int k = 0; k < c; k++)
                    if (judgeArr[i][2 + j] == answer[k])
                        if (j == k)
                            A += answer[k];
                        else
                            B += answer[k];
            if (A != judgeArr[i][0] || B != judgeArr[i][1])
                return false;
        }
        return true;
    }
}