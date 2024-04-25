import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int l = 0, m = 1, r = n - 1;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            switch (a) {
            case 1:
                arr[l] = n - i;
                l = m++;
                break;
            case 2:
                arr[m++] = n - i;
                break;
            case 3:
                arr[r--] = n - i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}