import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        String str;
        while ((str = br.readLine()) != null) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String sortedStr = new String(cArr);
            hm.putIfAbsent(sortedStr, new ArrayList<>());
            hm.get(sortedStr).add(str);
        }
        ArrayList<String> al = new ArrayList<>(hm.keySet());
        al.sort((o1, o2) -> hm.get(o1).size() != hm.get(o2).size() ? hm.get(o2).size() - hm.get(o1).size()
                : hm.get(o1).get(0).compareTo(hm.get(o2).get(0)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(5, hm.size()); i++) {
            ArrayList<String> words = hm.get(al.get(i));
            words.sort((o1, o2) -> o1.compareTo(o2));
            sb.append("Group of size ").append(words.size()).append(": ");
            HashSet<String> used = new HashSet<>();
            for (String word : words) {
                if (used.contains(word))
                    continue;
                used.add(word);
                sb.append(word).append(" ");
            }
            sb.append(".\n");
        }
        System.out.println(sb);
    }
}