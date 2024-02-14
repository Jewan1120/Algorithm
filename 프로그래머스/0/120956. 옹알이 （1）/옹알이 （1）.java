class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] strArr = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            for (String str : strArr) {
                babbling[i] = babbling[i].replaceAll(str, " ");
            }
             if (babbling[i].trim().length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}