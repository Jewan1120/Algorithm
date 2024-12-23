import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] table;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        KMP(str, target);
        System.out.println(sb);
    }

    private static void KMP(String str, String target) {
        makeTable(target);
        int strLen = str.length(), targetLen = target.length();
        int i = 0, cnt = 0;
        for (int j = 0; j < strLen; j++) {
            while (i > 0 && str.charAt(j) != target.charAt(i))
                i = table[i - 1];
            if (str.charAt(j) == target.charAt(i)) {
                if (i == targetLen - 1) {
                    cnt++;
                    sb.append(j - targetLen + 2).append(" ");
                    i = table[i];
                } else
                    i++;
            }
        }
        sb.insert(0, cnt + "\n");
    }

    private static void makeTable(String target) {
        int targetLen = target.length();
        table = new int[targetLen];
        int i = 0;
        for (int j = 1; j < targetLen; j++) {
            while (i > 0 && target.charAt(i) != target.charAt(j))
                i = table[i - 1];
            if (target.charAt(i) == target.charAt(j))
                table[j] = ++i;
        }
    }
}