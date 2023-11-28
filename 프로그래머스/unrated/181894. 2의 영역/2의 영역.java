class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (i < minIdx) {
                    minIdx = i;
                }
                maxIdx = i;
            }
        }
        if (maxIdx >= minIdx) {
            int[] tmp = new int[maxIdx - minIdx + 1];
            System.arraycopy(arr, minIdx, tmp, 0, maxIdx - minIdx + 1);
            answer = tmp;
        } else {
            answer = new int[] {-1};
        }
        return answer;
    }
}