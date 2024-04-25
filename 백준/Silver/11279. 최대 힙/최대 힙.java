import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (; n > 0; n--) {
            int p = Integer.parseInt(br.readLine());
            if (p == 0) {
                if (pq.isEmpty()){
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(p);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}