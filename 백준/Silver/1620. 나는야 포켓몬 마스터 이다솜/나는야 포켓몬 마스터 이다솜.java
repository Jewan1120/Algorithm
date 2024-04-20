import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> nameMap = new HashMap<>();
        HashMap<String, String> noMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String no = String.valueOf(i);
            nameMap.put(name, no);
            noMap.put(no, name);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (; M > 0; M--) {
            String str = br.readLine();
            if (nameMap.containsKey(str)) {
                bw.write(nameMap.get(str));
            } else {
                bw.write(noMap.get(str));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}