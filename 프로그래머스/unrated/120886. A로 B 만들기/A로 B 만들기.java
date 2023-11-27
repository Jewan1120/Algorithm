class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        for (char check : before.toCharArray()) {
            int count1 = 0;
            int count2 = 0;
            for (char c1 : before.toCharArray()) {
                if (check == c1) {
                    count1++;
                }
            }
            for (char c2 : after.toCharArray()) {
                if (check == c2) {
                    count2++;
                }
            }
            if (count1 != count2) {
                answer = 0;
                break;
            }
        }
        return answer;
    }
}