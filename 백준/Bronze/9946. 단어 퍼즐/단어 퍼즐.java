import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String chk;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        next: while (true) {
            str = br.readLine();
            chk = br.readLine();
            if (str.equals("END") && chk.equals("END"))
                break;

            sb.append("Case ").append(++idx).append(": ");
            if (str.length() != chk.length()) {
                sb.append("different\n");
                continue next;
            }

            int[] arr = new int[26];

            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
                arr[chk.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++)
                if (arr[i] != 0) {
                    sb.append("different\n");
                    continue next;
                }
            sb.append("same\n");
        }
        System.out.println(sb);
    }
}