import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (; t > 0; t--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long l1 = (long) (Math.pow(a + b, 2) + Math.pow(c, 2));
            long l2 = (long) (Math.pow(a + c, 2) + Math.pow(b, 2));
            long l3 = (long) (Math.pow(b + c, 2) + Math.pow(a, 2));
            long min = Math.min(l1, Math.min(l2, l3));
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}