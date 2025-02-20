import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {

    static HashMap<Character, Integer> hm = new HashMap<>();
    static {
        hm.put('(', 1);
        hm.put(')', -1);
        hm.put('[', 2);
        hm.put(']', -2);
        hm.put('{', 3);
        hm.put('}', -3);
        hm.put('<', 4);
        hm.put('>', -4);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int result = isPossible(len, str) ? 1 : 0;
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int len, String str) {
        int[] brackets = new int[5];
        if (len % 2 == 1)
            return false;
        for (int i = 0; i < len; i++) {
            int type = hm.get(str.charAt(i));
            if (type >= 0)
                brackets[type]++;
            else {
                brackets[-type]--;
                if (brackets[-type] < 0)
                    return false;
            }
        }
        for (int type : brackets)
            if (type != 0)
                return false;
        return true;
    }
}
