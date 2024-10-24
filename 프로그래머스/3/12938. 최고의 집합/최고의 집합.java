class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (n > s)
            return new int[] { -1 };
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = s / n;
            if (s % n != 0)
                answer[i]++;
            n--;
            s -= answer[i];
        }
        return answer;
    }
}