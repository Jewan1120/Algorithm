import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (; n > 0; n--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            switch (oper) {
                case "push":
                    dq.offer(st.nextToken());
                    break;
                case "pop":
                    sb.append(dq.isEmpty() ? "-1" : dq.poll()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? "-1" : dq.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}