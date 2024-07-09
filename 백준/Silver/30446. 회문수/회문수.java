import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int cnt = 0;
        for (int i = 1; i < 100000; i++) {
            long pal = EvenPal(i);
            if (pal <= n) {
                cnt++;
            } else
                break;
        }
        for (int i = 1; i < 100000; i++) {
            long pal = OddPal(i);
            if (pal <= n) {
                cnt++;
            } else
                break;
        }
        System.out.println(cnt);
    }

    private static long EvenPal(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return Long.parseLong(s + sb.toString());
    }

    private static long OddPal(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse().deleteCharAt(0);
        return Long.parseLong(s + sb.toString());
    }
}