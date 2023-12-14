import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[] chkX = {0, 1, 0, 1};
        int[] chkY = {0, 0, 1, 1};
        boolean flg = true;
        while(flg){
            flg = false;
            boolean[][] pop = new boolean[m][n];
            for(int i = 0; i < m - 1; i++){
                next: for(int j = 0; j < n - 1; j++){
                    if(board[i].charAt(j) == ' ') continue;
                    for(int k = 1; k< 4; k++){
                        if(board[i].charAt(j) != board[i + chkY[k]].charAt(j + chkX[k])) continue next;
                    }
                    for(int k = 0; k < 4; k++){
                        pop[i + chkY[k]][j + chkX[k]] = true;
                    }
                }
            }
            ArrayList<Queue<Character>> newBoard = new ArrayList<>();
            for(int i = 0; i < n; i++){
                Queue<Character> que = new LinkedList<>();
                for(int j = m - 1; j >= 0; j--){
                    if(!pop[j][i]) que.add(board[j].charAt(i));
                    else{
                        answer++;
                        flg = true;
                    }
                }
                newBoard.add(que);
            }
            for(int i = m - 1; i >= 0; i--){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(newBoard.get(j).size() !=0) sb.append(newBoard.get(j).poll());
                    else sb.append(' ');
                }
                board[i] = sb.toString();
            }
        }
        return answer;
    }
}