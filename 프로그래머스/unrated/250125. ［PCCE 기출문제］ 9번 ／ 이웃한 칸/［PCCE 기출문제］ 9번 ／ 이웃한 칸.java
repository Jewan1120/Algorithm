class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for(int i = 0; i < 4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(0 <= h_check && h_check < n && 0 <= w_check && w_check < n ){
                if(board[h][w].equals(board[h_check][w_check])){
                    answer++;
                }
            }
        }
        return answer;
    }
}