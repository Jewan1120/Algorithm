import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        while (n > 0) {
            int cnt = 0;
            int temp = num;
            while (temp > 0) {
                if (temp % 10 == 6)
                    cnt++;
                else
                    cnt = 0;
                if (cnt == 3) {
                    n--;
                    continue;
                }
                temp /= 10;
            }
            if (n == 0)
                break;
            num++;
        }
        System.out.println(num);
    }
}