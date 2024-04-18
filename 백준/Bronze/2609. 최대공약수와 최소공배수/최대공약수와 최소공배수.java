import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        br.close();
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int gcd = GCD(a, b);
        int lcm = a * b / gcd;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(gcd + "\n");
        bw.write(lcm + "\n");
        bw.flush();
        bw.close();
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}