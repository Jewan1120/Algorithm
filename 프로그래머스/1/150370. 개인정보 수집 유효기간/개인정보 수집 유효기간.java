import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    
    int[] dateChk = new int[3];
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] date = today.split("\\.");
        for (int i = 0; i < 3; i++) {
            dateChk[i] = Integer.parseInt(date[i]);
        }
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            hm.put(term[0], Integer.parseInt(term[1]));
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] dateStrPart = privacy[0].split("\\.");
            int[] datePart = new int[3];
            for (int j = 0; j < 3; j++) {
                datePart[j] = Integer.parseInt(dateStrPart[j]);
            }
            datePart[1] += hm.get(privacy[1]);
            if (datePart[1] > 12) {
                datePart[0]++;
                datePart[1] %= 12;
            }
            datePart[2]--;
            if (datePart[2] == 0) {
                datePart[1]--;
                datePart[2] = 28;
                if(datePart[1] == 0) {
                    datePart[0]--;
                    datePart[1] = 12;
                }
            }
            if (!isPossible(datePart))
                al.add(i + 1);
        }
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            answer[i] = al.get(i);
        return answer;
    }
    
    private boolean isPossible(int[] datePart) {
        for (int i = 0; i < 3; i++) {
            if (datePart[i] < dateChk[i]) { 
                return false;
            }
        }
        return true;
    }
}