import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().trim().split(" ");
        String len = !strArr[0].equals("") ? String.valueOf(strArr.length) : "0";
        bw.write(len);
        bw.flush();
        bw.close();
        br.close();
    }
}
