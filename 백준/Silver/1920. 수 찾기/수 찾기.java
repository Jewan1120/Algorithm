import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        HashSet<String> hs = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            hs.add(st.nextToken());
        }
        br.readLine();
        String[] strArr = br.readLine().split(" ");
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String str : strArr) {
            bw.write((hs.contains(str) ? 1 : 0) + "\n");
        }
        bw.flush();
        bw.close();
    }
}