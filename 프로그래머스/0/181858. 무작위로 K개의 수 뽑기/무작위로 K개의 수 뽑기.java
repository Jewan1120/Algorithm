class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        start: for (int i : arr) {

            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == i) {
                  continue start;
                }
            }
            int[] tmp = new int[answer.length + 1];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            tmp[answer.length] = i;
            answer = tmp;
            if (answer.length == k)
                break;
        }
        if (answer.length < k) {
            int[] tmp = new int[k];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            for (int i = answer.length; i < k; i++) {
                tmp[i] = -1;
            }
            answer = tmp;
        }
        return answer;
    }
}