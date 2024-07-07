import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            double d = Double.parseDouble(st.nextToken());
            while (st.hasMoreTokens()) {
                switch (st.nextToken()) {
                    case "@":
                        d *= 3;
                        break;
                    case "%":
                        d += 5;
                        break;
                    case "#":
                        d -= 7;
                        break;
                }
            }
            sb.append(String.format("%.2f", d)).append("\n");
        }
        System.out.println(sb);
    }
}