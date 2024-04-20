import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        long l = 1;
        long r = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            arr[i] = len;
            if (len > r) {
                r = len;
            }
        }
        br.close();
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int i : arr)
                cnt += i / mid;
            if (cnt < p) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(r);
    }
}