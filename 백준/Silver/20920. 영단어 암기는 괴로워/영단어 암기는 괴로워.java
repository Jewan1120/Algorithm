import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m)
                hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        TreeSet<String> ts = new TreeSet<>((s1, s2) -> (hm.get(s1) != hm.get(s2) ? hm.get(s2) - hm.get(s1)
                : s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2)));
        for (String str : hm.keySet()) {
            ts.add(str);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : ts) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}