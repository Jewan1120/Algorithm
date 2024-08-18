import java.util.Stack;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            stk.push(i);
            sb.append("+\n");
            while (!stk.isEmpty() && stk.peek() == arr[idx]) {
                stk.pop();
                sb.append("-\n");
                idx++;
            }
        }
        if (!stk.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println(sb);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}