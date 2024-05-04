import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (; t > 0; t--) {
            TreeMap<Integer, Integer> ts = new TreeMap<>();
            StringTokenizer st;
            int k = Integer.parseInt(br.readLine());
            for (; k > 0; k--) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (oper.equals("I")) {
                    ts.putIfAbsent(n, 0);
                    ts.replace(n, ts.get(n) + 1);
                } else if (!ts.isEmpty()) {
                    int key;
                    if (n == 1) {
                        key = ts.lastKey();
                        ts.replace(key, ts.get(key) - 1);
                    } else {
                        key = ts.firstKey();
                        ts.replace(key, ts.get(key) - 1);
                    }
                    if (ts.get(key) == 0) {
                        ts.remove(key);
                    }
                }
            }
            if (ts.isEmpty()) {
                bw.write("EMPTY");
            } else {
                bw.write(ts.lastKey() + " " + ts.firstKey());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}