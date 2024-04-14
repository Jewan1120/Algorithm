import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb;
        for (; i > 0; i--) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                sb.append(String.valueOf(str.charAt(j)).repeat(n));
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}