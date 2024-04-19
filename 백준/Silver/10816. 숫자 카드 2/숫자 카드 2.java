import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (hm.containsKey(str)) {
                hm.replace(str, hm.get(str) + 1);
            } else {
                hm.put(str, 1);
            }
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (hm.containsKey(str)) {
                sb.append(hm.get(str));
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}