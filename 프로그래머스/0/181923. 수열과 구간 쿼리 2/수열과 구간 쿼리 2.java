class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            boolean flg = true;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    flg = false;
                    if (min > arr[j]) {
                        min = arr[j];
                    }
                }
            }
            if (flg) {
                min = -1;
            }
            answer[i] = min;
        }
        return answer;
    }
}