import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quadrant = 0;
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if (a > 0) {
            quadrant = b > 0 ? 1 : 4;
        } else {
            quadrant = b > 0 ? 2 : 3;
        }
        bw.write(String.valueOf(quadrant));
        bw.flush();
        bw.close();
        br.close();
    }
}
