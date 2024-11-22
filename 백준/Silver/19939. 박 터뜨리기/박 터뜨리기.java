import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int need = 0;
        for (int i = 1; i <= k; i++)
            need += i;
        if (n < need) {
            System.out.println(-1);
            return;
        }
        int min = n / need, max = min + k - 1;
        int remain = (n - need) % k;
        if (remain != 0) {
            max++;
        }
        System.out.println(max - min);
    }
}