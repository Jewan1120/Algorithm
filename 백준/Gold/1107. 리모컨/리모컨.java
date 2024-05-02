import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int min = Math.abs(100 - n);
        boolean[] chk = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int idx = Integer.parseInt(st.nextToken());
                chk[idx] = true;
            }
        }
        for (int i = 0; i < 1_000_000; i++) {
            int len = checkChannel(i, chk);
            if (len > 0) {
                int cnt = Math.abs(i - n);
                min = Math.min(min, cnt + len);
            }
        }
        System.out.println(min);
        br.close();
    }

    static int checkChannel(int i, boolean[] chk) {
        if (i == 0) {
            return chk[0] ? 0 : 1;
        }
        int len = 0;
        while (i > 0) {
            if (chk[i % 10]) {
                return 0;
            }
            len++;
            i /= 10;
        }
        return len;
    }
}