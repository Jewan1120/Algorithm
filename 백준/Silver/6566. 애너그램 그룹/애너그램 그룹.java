import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<String>> words = new ArrayList<>();
        ArrayList<int[]> chkList = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            int[] chkArr = check(str);
            boolean flg = false;
            for (int i = 0; i < words.size(); i++) {
                if (isPossible(chkArr, chkList.get(i))) {
                    flg = true;
                    words.get(i).add(str);
                }
            }
            if (!flg) {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                words.add(al);
                chkList.add(chkArr);
            }
        }
        words.sort((o1, o2) -> o1.size() != o2.size() ? o2.size() - o1.size() : o1.get(0).compareTo(o2.get(0)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(5, words.size()); i++) {
            ArrayList<String> al = words.get(i);
            al.sort((o1, o2) -> o1.compareTo(o2));
            sb.append("Group of size ").append(al.size()).append(": ");
            HashSet<String> used = new HashSet<>();
            for (String item : al) {
                if (used.contains(item))
                    continue;
                used.add(item);
                sb.append(item).append(" ");
            }
            sb.append(".\n");
        }
        System.out.println(sb);
    }

    private static int[] check(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            arr[idx]++;
        }
        return arr;
    }

    private static boolean isPossible(int[] chkA, int[] chkB) {
        for (int i = 0; i < 26; i++)
            if (chkA[i] != chkB[i])
                return false;
        return true;
    }
}