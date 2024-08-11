import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] chk = br.readLine().toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            dq.offerLast(arr[i]);
            int idx = chk.length - 1;
            while (!dq.isEmpty() && dq.peekLast() == chk[idx]) {
                temp.offerLast(dq.pollLast());
                if (--idx < 0)
                    break;
            }
            if (temp.size() == chk.length)
                temp.clear();
            while (!temp.isEmpty())
                dq.offerLast(temp.pollLast());
        }
        if (dq.isEmpty())
            System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!dq.isEmpty())
                sb.append(dq.pollFirst());
            System.out.println(sb);
        }
    }
}