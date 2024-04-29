import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                int[] arr = {Math.abs(num), num};
                pq.add(arr);
            } else {
                if (!pq.isEmpty()) {
                    bw.write(pq.poll()[1] + "\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}