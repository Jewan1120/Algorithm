import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] result;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        dfs(0);
    }

    private static void dfs(int depth) {
        for (int i = 0; i < depth - 1; i++) {
            for (int j = 1; j <= (depth - i) / 2; j++) {
                boolean isGood = false;
                for (int k = 0; k < j; k++) {
                    if (result[i + k] != result[i + k + j]) {
                        isGood = true;
                        break;
                    }
                }
                if (!isGood) {
                    return;
                }
            }
        }
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : result)
                sb.append(i);
            System.out.println(sb);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}