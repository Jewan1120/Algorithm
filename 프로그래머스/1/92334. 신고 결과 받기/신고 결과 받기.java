import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reported = new HashMap<String, Integer>();
        HashMap<String, HashSet<String>> idMap = new HashMap<String, HashSet<String>>();
        HashSet<String> mailSet = new HashSet<String>();
        for (String id : id_list) {
            idMap.put(id, new HashSet<String>());
        }
        for (String str : report) {
            String[] detail = str.split(" ");
            idMap.get(detail[0]).add(detail[1]);
        }
        for (String id : id_list) {
            for (String reportedId : idMap.get(id)) {
                if (!reported.containsKey(reportedId)) {
                    reported.put(reportedId, 1);
                } else {
                    int i = reported.get(reportedId) + 1;
                    reported.replace(reportedId, i);
                }
                if (reported.get(reportedId) == k) {
                    mailSet.add(reportedId);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (String mail : mailSet) {
                if (idMap.get(id_list[i]).contains(mail)) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}