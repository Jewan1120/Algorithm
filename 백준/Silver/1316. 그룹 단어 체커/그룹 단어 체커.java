import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        next: for (; n > 0; n--) {
            char[] cArr = br.readLine().toCharArray();
            char temp = 0;
            boolean[] chk = new boolean[26];
            for (char c : cArr) {
                if (!chk[c - 'a']) {
                    temp = c;
                    chk[c - 'a'] = true;
                } else {
                    if (c != temp) {
                        continue next;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}