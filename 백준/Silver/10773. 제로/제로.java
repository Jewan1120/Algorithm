import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stk = new Stack<>();
        for (; n > 0; n--) {
            int r = Integer.parseInt(br.readLine());
            if (r == 0) {
                sum -= stk.pop();
            } else {
                sum += stk.push(r);
            }
        }
        System.out.println(sum);
        br.close();
    }
}