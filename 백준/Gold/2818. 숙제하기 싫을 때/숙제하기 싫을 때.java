import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());
        long sum = 0;
        sum += (c / 4) * 2 * 7 * r;
        c %= 4;
        if (c == 1) {
            int[] sumArr = { 0, 1, 6, 12 };
            sum += (r / 4) * 2 * 7 + sumArr[(int) r % 4];
        } else if (c == 2) {
            int[] sumArr = { 0, 5, 11, 19, 28, 36 };
            sum += (r / 6) * 3 * 2 * 7 + sumArr[(int) r % 6];
        } else if (c == 3) {
            sum += r * 11;
        }
        System.out.println(sum);
    }
}