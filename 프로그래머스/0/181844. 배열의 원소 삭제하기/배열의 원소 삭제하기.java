class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        next: for (int i = 0; i < arr.length; i++) {
            for (int j : delete_list) {
                if (arr[i] == j) {
                    continue next;
                }
            }
            int[] tmp = new int[answer.length + 1];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            tmp[answer.length] = arr[i];
            answer = tmp;
        }
        return answer;
    }
}