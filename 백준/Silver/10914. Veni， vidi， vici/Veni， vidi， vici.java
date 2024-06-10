import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            char[] arr = st.nextToken().toCharArray();
            for (int i = 0; i < arr.length - 1; i += 2){
                sb.append((char) ((arr[i] + arr[i + 1] - 168 - n) % 26 + 97));
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}