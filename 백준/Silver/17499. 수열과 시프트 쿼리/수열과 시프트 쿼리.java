import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (oper == 1) {
                int p = Integer.parseInt(st.nextToken());
                arr[(idx + s - 1 + n) % n] += p;
            } else if (oper == 2) {
                idx = (idx - s + n) % n;
            } else {
                idx = (idx + s + n) % n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[(idx + i) % n]).append(" ");
        }
        System.out.println(sb);
    }
}