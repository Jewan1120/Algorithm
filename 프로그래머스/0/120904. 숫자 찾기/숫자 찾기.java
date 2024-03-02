class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        while (num > 0) {
            if (k == num % 10) {
                answer = (int) Math.log10(num) + 1;
            }
            num /= 10;
        }
        return answer;
    }
}