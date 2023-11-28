class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int n = (intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2);
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (intervals[i][0] <= j && j <= intervals[i][1]) {
                    answer[idx] = arr[j];
                    idx++;
                }
            }
        }
        return answer;
    }
}