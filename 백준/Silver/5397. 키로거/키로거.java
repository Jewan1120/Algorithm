import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Character> lq;
        Deque<Character> rq;
        for (int i = 0; i < n; i++) {
            lq = new ArrayDeque<>();
            rq = new ArrayDeque<>();
            char[] cArr = br.readLine().toCharArray();
            for (char c : cArr) {
                switch (c) {
                    case '<':
                        if (!lq.isEmpty()) {
                            rq.offerFirst(lq.pollLast());
                        }
                        break;
                    case '>':
                        if (!rq.isEmpty()) {
                            lq.offerLast(rq.pollFirst());
                        }
                        break;
                    case '-':
                        lq.pollLast();
                        break;
                    default:
                        lq.offerLast(c);
                        break;
                }
            }
            for (char c : lq) {
                sb.append(c);
            }
            for (char c : rq) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}