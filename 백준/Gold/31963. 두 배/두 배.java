import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long answer = 0;
        int[] multiplyCount = new int[N];
        for (int i = 1; i < N; i++) {
            int neededMultiply = (int) Math.ceil(Math.log((double) arr[i - 1] / arr[i]) / Math.log(2));
            multiplyCount[i] = Math.max(neededMultiply + multiplyCount[i - 1], 0);
            answer += multiplyCount[i];
        }
        System.out.println(answer);
    }
}