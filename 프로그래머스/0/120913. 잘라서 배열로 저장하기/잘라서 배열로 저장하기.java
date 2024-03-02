class Solution {
    public String[] solution(String my_str, int n) {
        int arrLength = my_str.length() % n != 0 ? my_str.length() / n + 1 : my_str.length() / n;
        String[] answer = new String[arrLength];
        for (int i = 0; i < answer.length; i++) {
            if (i == arrLength - 1) {
                answer[i] = my_str.substring(i * n);
            } else {
                answer[i] = my_str.substring(i * n, (i + 1) * n);
            }
        }
        return answer;
    }
}