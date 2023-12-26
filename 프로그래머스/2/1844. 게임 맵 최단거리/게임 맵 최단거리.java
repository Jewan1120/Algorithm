import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[][] maps) {
        int answer = 1;
        int m = maps.length - 1;
        int n = maps[0].length - 1;
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> tmp = new LinkedList<>();
        que.add(new int[2]);
        while(!que.isEmpty()){
            int[] p = que.poll();
            if(maps[p[0]][p[1]] == 1){
                maps[p[0]][p[1]] = 0;
                if(p[0] == m && p[1] == n) break;
                if(0 < p[0] && maps[p[0] - 1][p[1]] == 1) tmp.add(new int[]{p[0] - 1, p[1]}); // U
                if(p[0] < m && maps[p[0] + 1][p[1]] == 1) tmp.add(new int[]{p[0] + 1, p[1]}); // D
                if(0 < p[1] && maps[p[0]][p[1] - 1] == 1) tmp.add(new int[]{p[0], p[1] - 1}); // R
                if(p[1] < n && maps[p[0]][p[1] + 1] == 1) tmp.add(new int[]{p[0], p[1] + 1}); // L   
            }
            if(que.isEmpty()){
                if(tmp.isEmpty()){
                    answer = -1;
                    break;
                }
                que.addAll(tmp);
                answer++;
                tmp.clear();
            }
        }
        return answer;
    }
}