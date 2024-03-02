class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isUpperCase(my_string.charAt(i))) {
                answer[my_string.charAt(i) - 65]++;
            } else {
                answer[my_string.charAt(i) - 71]++;
            }
        }
        return answer;
    }
}