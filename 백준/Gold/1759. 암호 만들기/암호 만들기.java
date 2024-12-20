import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, c;
    static String[] strArr;
    static String[] result;
    static List<String> vowels = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        strArr = new String[c];
        for (int i = 0; i < c; i++)
            strArr[i] = st.nextToken();
        Arrays.sort(strArr);
        result = new String[n];
        recursive(0, 0, 0);
        System.out.println(sb);
    }

    private static void recursive(int depth, int p, int vCnt) {
        if (depth == n) {
            if (vCnt > 0 && depth - vCnt > 1) {
                for (int i = 0; i < n; i++)
                    sb.append(result[i]);
                sb.append("\n");
            }
            return;
        }
        for (int i = p; i < c; i++) {
            result[depth] = strArr[i];
            if (vowels.contains(strArr[i]))
                recursive(depth + 1, i + 1, vCnt + 1);
            else
                recursive(depth + 1, i + 1, vCnt);
        }
    }
}