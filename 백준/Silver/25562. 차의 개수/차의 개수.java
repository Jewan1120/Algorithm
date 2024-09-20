import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(n * (n - 1) / 2).append("\n");
        int num = 1;
        for (int i = 0; i < n; i++) {
            sb.append(num).append(" ");
            num *= 2;
        }
        sb.append("\n").append(n - 1).append("\n");
        num = 1;
        for (int i = 0; i < n; i++) {
            sb.append(num).append(" ");
            num++;
        }
        System.out.println(sb);
    }
}