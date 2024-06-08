import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        int p = 100001, max = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("O")) {
                    sum += score[j];
                }
            }
            if (max < sum) {
                max = sum;
                p = t;
            } else if (max == sum) {
                p = Math.min(p, t);
            }
        }
        System.out.println(p + " " + max);
    }
}