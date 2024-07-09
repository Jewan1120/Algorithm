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
        int temp = num;
        int len = ((int) Math.log10(num) + 1);
        long pal = num * (long) Math.pow(10, len);
        for (int i = 1; i <= len; i++) {
            pal += (temp % 10) * (long) Math.pow(10, len - i);
            temp /= 10;
        }
        return pal;
    }

    private static long OddPal(int num) {
        int temp = num / 10;
        int len = (int) Math.log10(num);
        long pal = num * (long) Math.pow(10, len);
        for (int i = 1; i <= len; i++) {
            pal += (temp % 10) * (long) Math.pow(10, len - i);
            temp /= 10;
        }
        return pal;
    }
}