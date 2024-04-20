import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int i = 1; i <= n; i++) {
            stk.push(i);
            sb.append("+\n");
            while (!stk.isEmpty() && stk.peek() == arr[p]) {
                stk.pop();
                sb.append("-\n");
                p++;
            }
        }
        if (!stk.isEmpty())
            sb = new StringBuilder("NO");
        System.out.println(sb.toString());
    }
}