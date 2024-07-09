import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && (arr[stk.peek()] <= arr[i]))
                stk.pop();
            if (!stk.isEmpty())
                result[i] = stk.peek() + 1;
            else
                result[i] = 0;
            stk.push(i);
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