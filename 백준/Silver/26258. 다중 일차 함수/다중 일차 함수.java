import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            double k = Double.parseDouble(br.readLine());
            int l = 0, r = n - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (arr[m][0] < k) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (arr[l - 1][1] == arr[l][1])
                sb.append(0);
            else {
                sb.append(arr[l - 1][1] < arr[l][1] ? 1 : -1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}