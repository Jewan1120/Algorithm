class Solution {
    public int[] solution(int[] arr) {
        int n = 0;
        int k = 0;
        for (int i : arr) {
            n += i;
        }
        int[] answer = new int[n];
        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                answer[k] = i;
                k++;
            }
        }
        return answer;
    }
}