import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb;
        for (; n > 0; n--) {
            sb = new StringBuilder();
            String str = br.readLine();
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length() - 1));
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
