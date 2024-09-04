import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> hm = new HashMap<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(br.readLine());
        while (r-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            boolean isdead = false;
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < p; i++) {
                String str = st.nextToken();
                if (hm.containsKey(str)) {
                    temp.append(hm.get(str)).append(" ");
                } else {
                    isdead = true;
                    break;
                }
            }
            if (isdead)
                sb.append("YOU DIED\n");
            else
                sb.append(temp.toString()).append("\n");
        }
        System.out.println(sb);
    }
}