class Solution {
    public int solution(int[] arr, int idx) {
        int answer = Integer.MAX_VALUE;
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer = i;
                break;
            }
        }
        return answer != Integer.MAX_VALUE ? answer : -1;
    }
}