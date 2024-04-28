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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] p1 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int r1 = Integer.parseInt(st.nextToken());
            int[] p2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int r2 = Integer.parseInt(st.nextToken());
            double d = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
            if (d == 0 && r1 == r2) {
                bw.write("-1");
            } else if (r1 + r2 == d || Math.abs(r1 - r2) == d) {
                bw.write("1");
            } else if (r1 + r2 > d && Math.abs(r1 - r2) < d) {
                bw.write("2");
            } else {
                bw.write("0");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}