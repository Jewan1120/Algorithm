class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int direction = 0;
        int x = 0;
        int y = 0;
        
        int dx = 0;
        int dy = 0;
        
        for (int i = 1; i <= Math.pow(n, 2); i++){
            answer[y][x] = i;

          switch (direction % 4) {
            case 0:
              x++;
              if (x == (n - 1) - dx) {
                direction++;
                }
              break;
            case 1:
              y++;
              if (y == (n - 1) - dy) {
                direction++;
                }
              break;
            case 2:
              x--;
              if (x == dx) {
                direction++;
                dy++;
                }
              break;
            case 3:
              y--;
              if (y == dy) {
                direction++;
                dx++;
                }
            }
        }
        return answer;
    }
}