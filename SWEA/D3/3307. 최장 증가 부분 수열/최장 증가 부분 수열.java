import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int len = 0;
            int[] lis = new int[n];
            for (int i = 0; i < n; i++) {
                int pos = Arrays.binarySearch(lis, 0, len, arr[i]);
                if (pos < 0)
                    pos = ~pos;
                lis[pos] = arr[i];
                if (pos == len)
                    len++;
            }
            sb.append("#").append(tc).append(" ").append(len).append("\n");
        }
        System.out.println(sb);
    }
}
