import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb;
        while (!(str = br.readLine()).equals("# 0 0")) {
            String[] info = str.split(" ");
            sb = new StringBuilder(info[0]).append(" ");
            if (Integer.parseInt(info[1]) > 17 || Integer.parseInt(info[2]) >= 80) {
                sb.append("Senior\n");
            } else {
                sb.append("Junior\n");
            }
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}