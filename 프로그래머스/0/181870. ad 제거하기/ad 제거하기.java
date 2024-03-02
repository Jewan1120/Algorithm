class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        for (String str : strArr) {
            if (!str.contains("ad")) {
                String[] tmp = new String[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = str;
                answer = tmp;
            }
        }
        return answer;
    }
}