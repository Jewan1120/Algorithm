import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        int l = 0;
        int r = cArr.length - 1;
        while (l < r) {
            if (cArr[l++] != cArr[r--]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}