import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> strMap = new TreeSet<>(
                (o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2));
        for (; n > 0; n--) {
            strMap.add(br.readLine());
        }
        for (String str : strMap) {
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}