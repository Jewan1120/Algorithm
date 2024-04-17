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
        while (!(str = br.readLine()).equals("0")) {
            StringBuilder sb = new StringBuilder(str).reverse();
            if (str.equals(sb.toString())) bw.write("yes");
            else bw.write("no");
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}