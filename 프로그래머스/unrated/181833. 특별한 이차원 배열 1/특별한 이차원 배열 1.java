class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < answer.length; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }
}