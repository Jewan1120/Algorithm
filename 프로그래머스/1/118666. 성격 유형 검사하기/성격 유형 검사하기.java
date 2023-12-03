import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> response = new HashMap<String, Integer>();
        String[] type = {"RT", "CF", "JM", "AN"};
        for (int i = 0; i < survey.length; i++) {
            if (survey[i].charAt(0) > survey[i].charAt(1)) {
                StringBuilder tmp = new StringBuilder();
                survey[i] = tmp.append(survey[i]).reverse().toString();
                choices[i] = choices[i] * -1 + 4;
            } else {
                choices[i] -= 4;
            }
            response.put(survey[i], response.getOrDefault(survey[i], 0) + choices[i]);
        }
        for (int i = 0; i < 4; i++) {
            if (response.getOrDefault(type[i], 0) > 0) {
                sb.append(type[i].charAt(1));
            } else {
                sb.append(type[i].charAt(0));
            }
        }
        return sb.toString();
    }
}