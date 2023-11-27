class Solution {
    public int solution(int n) {
        int answer = 0;
        int factorial = 1;
        while (factorial * answer < n) {
            answer++;
            factorial *= answer;
        }
        return answer;
    }
}