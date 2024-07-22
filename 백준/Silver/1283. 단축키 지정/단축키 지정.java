import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Character> hs = new HashSet<>();
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            String[] words = strArr[i].split(" ");
            StringBuilder sb = new StringBuilder();
            boolean flg = false;
            for (int j = 0; j < words.length; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));
                if (!hs.contains(c)) {
                    hs.add(c);
                    sb.append("[").append(words[j].charAt(0)).append("]").append(words[j].substring(1));
                    words[j] = sb.toString();
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                loop: for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = Character.toLowerCase(words[j].charAt(k));
                        if (!hs.contains(c)) {
                            hs.add(c);
                            sb.append(words[j].substring(0, k)).append("[").append(words[j].charAt(k))
                                    .append("]").append(words[j].substring(k + 1));
                            words[j] = sb.toString();
                            flg = true;
                            break loop;
                        }
                    }
                }
            }
            strArr[i] = String.join(" ", words);
        }
        for (String str : strArr) {
            System.out.println(str);
        }
    }
}