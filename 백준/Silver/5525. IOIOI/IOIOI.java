import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();
        boolean flg = false;
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < m; i++) {
            if ((!flg && cArr[i] == 'I') || (flg && cArr[i] == 'O')) {
                flg = !flg;
            } else {
                cnt = 0;
            }
            if (cArr[i] == 'I') {
                cnt++;
            }
            if (cnt > n && cArr[i] == 'I') {
                result++;
            }
        }
        System.out.println(result);
    }
}