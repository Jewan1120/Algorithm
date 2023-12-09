import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
class Solution {
    public int[] solution(String s) {
        String[] sArr = s.replaceAll("[\\{+]|\\}{2,}", "").split("},");
        int[] answer = new int[sArr.length];
        Arrays.sort(sArr, (s1, s2) -> s1.length() - s2.length());
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (String strArr : sArr) {
            for (String str : strArr.split(",")) {
                int i = Integer.parseInt(str);
                if (!hs.contains(i)) {
                    hs.add(i);
                    al.add(i);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}