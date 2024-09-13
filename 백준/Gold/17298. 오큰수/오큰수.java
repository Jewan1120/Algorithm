import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i])
                stk.pop();
            result[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result)
            sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}