class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a == 0) {
                n += b;
                answer += b;
            }
        }
        return answer;
    }
}