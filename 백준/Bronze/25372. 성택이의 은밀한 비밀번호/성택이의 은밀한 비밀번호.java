import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int len = br.readLine().length();
            sb.append(6<=len && len <= 9 ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}