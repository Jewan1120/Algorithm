import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] chk = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !chk[i][j]){
                    numberOfArea++;
                    int sizeOfOneArea = bfs(picture, chk, new int[]{i, j});
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture, boolean[][] chk, int[] p){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int m = picture.length;
        int n = picture[0].length;
        int color = picture[p[0]][p[1]];
        int count = 0;
        Queue<int[]> areaQue = new ArrayDeque<>();
        chk[p[0]][p[1]] = true;
        count++;
        areaQue.add(p.clone());
        while(!areaQue.isEmpty()){
            int[] area = areaQue.poll();
            for(int i = 0; i < 4; i++){
                int x = area[1] + dx[i];
                int y = area[0] + dy[i];
                if(0 <= x && x < n && 0 <= y && y < m){
                    if(!chk[y][x] && picture[y][x] == color){
                        chk[y][x] = true;
                        count++;
                        areaQue.add(new int[]{y, x});
                    }
                }
            }
        }
        return count;
    }
}