import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (; n > 0; n--) {
            arr[n - 1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = 0;
        int time = 0;
        for (int i : arr) {
            time += i;
            result += time;
        }
        System.out.println(result);
    }
}