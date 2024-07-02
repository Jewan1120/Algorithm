import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[26];
    static char[] comb;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        n = cArr.length;
        comb = new char[n];
        for (char c : cArr) {
            arr[c - 'a']++;
        }
        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if (depth == comb.length) {
            cnt++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && (depth == 0 || comb[depth - 1] != 'a' + i)) {
                comb[depth] = (char) ('a' + i);
                arr[i]--;
                dfs(depth + 1);
                arr[i]++;
            }
        }
    }
}