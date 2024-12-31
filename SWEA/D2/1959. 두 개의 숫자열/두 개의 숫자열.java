import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int caseNum = 0;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                A[i] = Integer.parseInt(st.nextToken());
            B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                B[i] = Integer.parseInt(st.nextToken());
            sb.append("#").append(++caseNum).append(" ").append(calculate()).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculate() {
        int max = Integer.MIN_VALUE;
        if (n >= m) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        for (int i = 0; i <= B.length - A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++)
                sum += A[j] * B[i + j];
            max = Math.max(max, sum);
        }
        return max;
    }
}