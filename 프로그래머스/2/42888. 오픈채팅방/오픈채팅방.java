import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> idMap = new HashMap<>();
        HashMap<String, String> logMap = new HashMap<>();
        logMap.put("Enter", "님이 들어왔습니다.");
        logMap.put("Leave", "님이 나갔습니다.");
        int count = 0;
        for (String info : record) {
            String[] infoArr = info.split(" ");
            if (!infoArr[0].equals("Change"))
                count++;
            if (!infoArr[0].equals("Leave"))
                idMap.put(infoArr[1], infoArr[2]);
        }
        String[] answer = new String[count];
        int index = 0;
        for (String info : record) {
            String[] infoArr = info.split(" ");
            if (!infoArr[0].equals("Change")) {
                StringBuilder sb = new StringBuilder();
                sb.append(idMap.get(infoArr[1])).append(logMap.get(infoArr[0]));
                answer[index++] = sb.toString();
            }
        }
        return answer;
    }
}