import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int t = a * b;
        StringBuilder sb = new StringBuilder();
        while (b > 0) {
            sb.append(a * (b % 10)).append("\n");
            b /= 10;
        }
        sb.append(t);
        System.out.println(sb.toString());
    }
}