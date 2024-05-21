import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (char c : br.readLine().toCharArray()) {
            left.offerLast(c);
        }
        int n = Integer.parseInt(br.readLine());
        for (; n > 0; n--) {
            String oper = br.readLine();
            switch (oper.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.offerFirst(left.pollLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.offerLast(right.pollFirst());
                    }
                    break;
                case 'B':
                    left.pollLast();
                    break;
                case 'P':
                    left.offerLast(oper.charAt(2));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.append(c);
        }
        for (char c : right) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}