import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();
        int len = cArr.length;
        for (int i = 1; i < n; i++) {
            char[] chk = br.readLine().toCharArray();
            for (int j = 0; j < len; j++) {
                if (cArr[j] != '?' && cArr[j] != chk[j]) {
                    cArr[j] = '?';
                }
            }
        }
        System.out.println(new String(cArr));
        br.close();
    }
}