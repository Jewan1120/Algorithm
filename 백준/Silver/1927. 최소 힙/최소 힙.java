import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (; n > 0; n--) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}