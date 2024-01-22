class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int o = 0, x = 0, oW = 0, xW = 0;
        for (String str : board) {
            for (char c : str.toCharArray()) {
                if (c == 'O') {
                    o++;
                } else if (c == 'X') {
                    x++;
                }
            }
        }
        if (o == x && o == 0) return 1;
        if (o - x > 1 || x > o) return 0;
        if (board[0].charAt(0) != '.' && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if (xW == 0 && board[0].charAt(0) == 'O' && o == x + 1) {
                oW++;
            } else if(oW == 0 && board[0].charAt(0) == 'X' && o == x) {
                xW++;
            } else return 0;
        }
        if (board[0].charAt(2) != '.' && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if (xW == 0 && board[0].charAt(2) == 'O' && o == x + 1) {
                oW++;
            } else if(oW == 0 && board[0].charAt(2) == 'X' && o == x) {
                xW++;
            } else return 0;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) != '.' && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if (xW == 0 && board[i].charAt(0) == 'O' && o == x + 1) {
                    oW++;
                } else if (oW == 0 && board[i].charAt(0) == 'X' && o == x) {
                    xW++;
                } else return 0;
            }
            if (board[0].charAt(i) != '.' && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (xW == 0 && board[0].charAt(i) == 'O' && o == x + 1) {
                    oW++;
                } else if (oW == 0 && board[0].charAt(i) == 'X' && o == x) {
                    xW++;
                } else return 0;
            }
        }
        return 1;
    }
}