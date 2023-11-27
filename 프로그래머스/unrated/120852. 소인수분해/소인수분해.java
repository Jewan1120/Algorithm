class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int divisor = 2;
        while (n > 1) {
            if (n % divisor == 0) {
                if (answer.length == 0) {
                    answer = new int[] {divisor};
                } else if (answer[answer.length - 1] != divisor) {
                    int[] tmp = new int[answer.length + 1];
                    System.arraycopy(answer, 0, tmp, 0, answer.length);
                    tmp[answer.length] = divisor;
                    answer = tmp;
                }
                n /= divisor;
            } else {
                divisor++;
            }
        }
        return answer;
    }
}