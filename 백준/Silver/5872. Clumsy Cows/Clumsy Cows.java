import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : line.toCharArray()) {
            if (dq.isEmpty() || c == '(')
                dq.offerLast(c);
            else {
                if (dq.peekLast() == '(')
                    dq.pollLast();
                else
                    dq.offerLast(c);
            }
        }
        int cnt = 0;
        while (!dq.isEmpty()) {
            char pc = dq.pollFirst();
            char nc = dq.pollFirst();
            if (pc == nc)
                cnt += 1;
            else
                cnt += 2;
        }
        System.out.println(cnt);
    }
}