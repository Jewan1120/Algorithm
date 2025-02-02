import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            Deque<Character> dq = new ArrayDeque<>();
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (dq.isEmpty()) {
                    dq.offerLast(c);
                    continue;
                }
                if (dq.peekLast() == '(' && c == ')')
                    dq.pollLast();
                else
                    dq.offerLast(c);
            }
            sb.append(dq.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}