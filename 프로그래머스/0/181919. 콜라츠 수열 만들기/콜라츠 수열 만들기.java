class Solution {
    public int[] solution(int n) {
        int[] answer = {n};
        while (n > 1) {
            n = n % 2 == 0 ? n /= 2 : 3 * n + 1;
            
            int[] tmp = new int[answer.length + 1];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            tmp[answer.length] = n;
            answer = tmp;
        }
        return answer;
    }
}