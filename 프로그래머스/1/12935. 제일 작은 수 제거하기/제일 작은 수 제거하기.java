class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[arr.length - 1];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        if (answer.length == 0) {
            answer = new int[] {-1};
        }
        return answer;
    }
}