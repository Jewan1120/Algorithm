import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chk = {'a', 'e', 'i', 'o', 'u'};
        String str;
        StringBuilder sb = new StringBuilder();
        while (!(str = br.readLine()).equals("#")) {
            char[] cArr = str.toCharArray();
            int cnt = 0;
            for (char c : cArr) {
                for (int i = 0; i < 5; i++)
                    if (Character.toLowerCase(c) == chk[i])
                        cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}