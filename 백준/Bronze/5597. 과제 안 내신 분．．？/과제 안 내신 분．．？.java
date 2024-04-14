import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] chk = new boolean[31];
        chk[0] = true;
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            chk[n] = true;
        }
        for (int i = 1; i <= 30; i++) {
            if (chk[i] == false) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
