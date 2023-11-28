class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            char c = s.charAt(i);
            int lastIdx = sb.lastIndexOf(String.valueOf(c));
            answer[i] = lastIdx == -1 ? -1 : i - lastIdx;
            sb.append(c);
        }
        return answer;
    }
}