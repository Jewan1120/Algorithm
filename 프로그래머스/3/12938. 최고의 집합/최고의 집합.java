class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s / n < 1) {
            return new int[] {-1};
        }
        int mod = s % n;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = s / n;
            if (mod > 0) {
                answer[i]++;
                mod--;
            }
        }
        return answer;
    }
}