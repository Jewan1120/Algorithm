import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean[] arr = new boolean[21];
        int n = Integer.parseInt(br.readLine());
        for (; n > 0; n--) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (oper) {
                case "add":
                    arr[x] = true;
                    break;
                case "remove":
                    arr[x] = false;
                    break;
                case "check":
                    bw.write(arr[x] ? "1\n" : "0\n");
                    break;
                case "toggle":
                    arr[x] = !arr[x];
                    break;
                case "all":
                    Arrays.fill(arr, true);
                    break;
                case "empty":
                    Arrays.fill(arr, false);
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}