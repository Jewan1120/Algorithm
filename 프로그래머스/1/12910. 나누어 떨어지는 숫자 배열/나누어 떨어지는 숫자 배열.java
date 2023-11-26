class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        for (int i : arr) {
            if (i % divisor == 0) {
                int[] tmp = new int[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = i;
                answer = tmp;
            }
        }
        if (answer.length == 0) {
            answer = new int[] {-1};
        }
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = 0; j < answer.length - i - 1; j++) {
                if (answer[j] > answer[j + 1]) {
                    int tmp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = tmp;
                }
            }
        }
        return answer;
    }
}