import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int y = 0, x = 0;
        for (int i = arr.length; i > 0; i--) {
            int m = (int) Math.pow(2, i - 1);
            char d = arr[arr.length - i];
            if (d == '1' || d == '3')
                x += m;
            if (d == '2' || d == '3')
                y += m;
        }
        sb.append(arr.length).append(" ").append(x).append(" ").append(y);
        System.out.println(sb);
    }
}