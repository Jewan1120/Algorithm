import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        InputStreamReader is = new InputStreamReader(System.in);
        bw.write(String.valueOf(is.read()));
        bw.flush();
        bw.close();
        is.close();
    }
}
