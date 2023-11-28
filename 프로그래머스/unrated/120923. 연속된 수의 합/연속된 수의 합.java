class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int avg = total / num;
        int center = num % 2 == 0 ? (num / 2) - 1 : num / 2;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = avg - center + i;
        }
        return answer;
    }
}