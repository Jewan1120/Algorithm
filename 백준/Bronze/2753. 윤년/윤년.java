import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        String result = "0";
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                result = "1";
            } else if (year % 400 == 0) {
                result = "1";
            }
        }
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
