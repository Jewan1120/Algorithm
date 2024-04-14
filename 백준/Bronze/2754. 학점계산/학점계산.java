import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char g = str.charAt(0);
        float n = 0;
        if (g != 'F') {
            n = 'E' - g;
            char o = str.charAt(1);
            if (o != '0') {
                if (o == '+')
                    n += 0.3;
                else
                    n -= 0.3;
            }
        }
        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
        br.close();
    }
}