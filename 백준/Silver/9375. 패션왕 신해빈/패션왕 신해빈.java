import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs;
        HashMap<String, Integer> hm;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (; n > 0; n--) {
            int m = Integer.parseInt(br.readLine());
            hs = new HashSet<>();
            hm = new HashMap<>();
            for (; m > 0; m--) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String cate = st.nextToken();
                hs.add(cate);
                hm.putIfAbsent(cate, 1);
                hm.replace(cate, hm.get(cate) + 1);
            }
            int cnt = 1;
            for (String cate : hs) {
                cnt *= hm.get(cate);
            }
            System.out.println(cnt - 1);
        }
    }
}