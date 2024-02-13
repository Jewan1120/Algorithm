import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Queue<int[]> que = new ArrayDeque<>();
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        for(int[] route : routes) que.add(route);
        while(!que.isEmpty()){
            int camera = que.peek()[1];
            while(que.peek()[0] <= camera){
                que.poll();
                if(que.isEmpty()) break;
            }
            answer++;
        }
        return answer;
    }
}