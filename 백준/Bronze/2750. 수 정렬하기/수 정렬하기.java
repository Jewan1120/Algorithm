import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2001];
        for (; n > 0; n--) {
            arr[Integer.parseInt(br.readLine()) + 1000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2001; i++) {
            if (arr[i]) {
                sb.append(i - 1000).append("\n");
            }
        }
        System.out.println(sb);
    }
}