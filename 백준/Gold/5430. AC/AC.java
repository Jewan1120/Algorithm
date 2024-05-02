import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        next: for (; t > 0; t--) {
            Deque<Integer> dq = new ArrayDeque<>();
            boolean flg = false;
            char[] cArr = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            for (int i = 0; i < n; i++) {
                dq.offer(Integer.parseInt(strArr[i]));
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < cArr.length; i++) {
                if (cArr[i] == 'R') {
                    flg = !flg;
                } else if (dq.isEmpty()) {
                    bw.write("error\n");
                    continue next;
                } else {
                    if (!flg) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
            while (!dq.isEmpty()) {
                if (!flg) {
                    sb.append(dq.pollFirst()).append(",");
                } else {
                    sb.append(dq.pollLast()).append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}