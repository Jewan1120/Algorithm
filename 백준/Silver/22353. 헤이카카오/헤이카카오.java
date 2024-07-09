import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());
        System.out.println(cal(a, d, k));

    }

    private static double cal(double a, double d, double k) {
        double winRate = d / 100.0;
        if (winRate >= 1)
            return a;
        double loseRate = 1 - winRate;
        double nextTime = a + cal(a, d * (1 + k / 100.0), k);
        return winRate * a + loseRate * nextTime;
    }
}