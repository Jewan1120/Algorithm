class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int n = 1;
        if (a == b && b == c) {
            n = 3;
        } else if (a == b ^ a == c ^ b == c) {
            n = 2;
        }
        for (int i = 1; i <= n; i++) {
            answer *= Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i);
        }
        return answer;
    }
}