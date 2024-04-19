import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = 0;
        int result = -1;
        while (n >= 0) {
            if (n % 5 == 0) {
                result = t + (n / 5);
                break;
            } else {
                n -= 3;
                t++;
            }
        }
        System.out.println(result);
    }
}