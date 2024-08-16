import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int intToday = strToInt(today);
        HashMap<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] StrArr = terms[i].split(" ");
            termsMap.put(StrArr[0], Integer.parseInt(StrArr[1]));
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] StrArr = privacies[i].split(" ");
            int privacyDate = strToInt(StrArr[0]) + termsMap.get(StrArr[1]) * 28 - 1;
            if (intToday > privacyDate)
                al.add(i + 1);
        }
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            answer[i] = al.get(i);
        return answer;
    }

    private int strToInt(String StrDate) {
        int intDate = 0;
        String[] strArr = StrDate.split("\\.");
        intDate += (Integer.parseInt(strArr[0]) - 2000) * 12 * 28;
        intDate += Integer.parseInt(strArr[1]) * 28;
        intDate += Integer.parseInt(strArr[2]);
        return intDate;
    }
}