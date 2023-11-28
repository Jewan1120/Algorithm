class Solution {
    public int solution(int[][] arr) {
        boolean flg = true;
        start: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] != arr[j][i]) {
                    flg = false;
                    break start;
                }
            }
        }
        return flg ? 1 : 0;
    }
}