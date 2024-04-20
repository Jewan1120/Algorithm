import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (; N > 0; N--) {
            hs.add(br.readLine());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (; M > 0; M--) {
            String str = br.readLine();
            if (hs.contains(str)) {
                al.add(str);
            }
        }
        al.sort((o1, o2) -> o1.compareTo(o2));
        bw.write(al.size() + "\n");
        for (String str : al) {
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}