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
        if (str.equals("1 2 3 4 5 6 7 8")) {
            bw.write("ascending");
        } else if (str.equals("8 7 6 5 4 3 2 1")) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
