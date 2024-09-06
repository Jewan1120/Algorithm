import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[3];
            for (int i = 0; i < 3; i++)
                arr[i] = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            Arrays.sort(arr);
            long len = arr[0] + arr[1] + arr[2] - d;
            long len2 = Math.min(len / 3, arr[0]);
            long len3 = Math.min((len - len2) / 2, arr[1]);
            sb.append(len3 * len2 * (len - len2 - len3)).append("\n");
        }
        System.out.println(sb);
    }
}