import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int min = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            String[] strArr = st.nextToken().split("\\+");
            int sum = 0;
            for (String str : strArr) {
                sum += Integer.parseInt(str);
            }
            if (min == Integer.MAX_VALUE) {
                min = sum;
            } else {
                min -= sum;
            }
        }
        System.out.println(min);
    }
}