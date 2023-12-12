import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String[]> hm = new HashMap<>();
        String defaultTime = "23:59";
        for (String str : records) {
            String[] strArr = str.split(" ");
            if (!hm.containsKey(strArr[1])) {
                String[] timeArr = new String[4];
                timeArr[0] = strArr[0];
                timeArr[1] = defaultTime;
                timeArr[2] = "0";
                timeArr[3] = strArr[2];
                hm.put(strArr[1], timeArr);
            } else {
                String[] timeArr = hm.get(strArr[1]);
                if (strArr[2].equals("OUT")) {
                    timeArr[1] = strArr[0];
                    timeArr[3] = strArr[2];
                    int timeIn = Integer.parseInt(timeArr[0].substring(0, 2)) * 60
                            + Integer.parseInt(timeArr[0].substring(3, 5));
                    int timeOut = Integer.parseInt(timeArr[1].substring(0, 2)) * 60
                            + Integer.parseInt(timeArr[1].substring(3, 5));
                    int totalTime = timeOut - timeIn;
                    timeArr[2] = String.valueOf(Integer.parseInt(timeArr[2]) + totalTime);
                } else {
                    timeArr[0] = strArr[0];
                    timeArr[1] = defaultTime;
                    timeArr[3] = strArr[2];
                }
            }
        }
        ArrayList<String> order = new ArrayList<>(hm.keySet());
        order.sort((s1, s2) -> s1.compareTo(s2));
        int[] answer = new int[hm.size()];
        for (int i = 0; i < order.size(); i++) {
            String[] timeArr = hm.get(order.get(i));
            int totalTime = Integer.parseInt(timeArr[2]);
            if (timeArr[3].equals("IN")) {
                int timeIn = Integer.parseInt(timeArr[0].substring(0, 2)) * 60
                        + Integer.parseInt(timeArr[0].substring(3, 5));
                totalTime += 1439 - timeIn;
            }
            int totalfee = fees[1];
            if (totalTime - fees[0] > 0) {
                totalfee += Math.ceil(((double)totalTime - fees[0]) / fees[2]) * fees[3];
            }
            answer[i] = totalfee;
        }
        return answer;
    }
}