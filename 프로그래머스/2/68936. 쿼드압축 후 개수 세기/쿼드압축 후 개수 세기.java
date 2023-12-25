import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = 0;
        Queue<int[]> que1 = new LinkedList<>();
        Queue<int[]> que2 = new LinkedList<>();
        que1.add(new int[2]);
        next: while(!que1.isEmpty() || !que2.isEmpty()){
            if(que1.isEmpty()){
                que1.addAll(que2);
                que2.clear();
                n++;
            }
            int[] tmp = que1.poll();
            int value = arr[tmp[0]][tmp[1]];
            int range = arr.length / (int) Math.pow(2, n);
            for(int i = 0; i < range; i++){
                for(int j = 0; j < range; j++){
                    if(value != arr[tmp[0] + i][tmp[1] + j]){
                        que2.add(new int[]{tmp[0], tmp[1]});
                        que2.add(new int[]{tmp[0], tmp[1] + (range / 2)});
                        que2.add(new int[]{tmp[0] + (range / 2), tmp[1]});
                        que2.add(new int[]{tmp[0] + (range / 2), tmp[1] + (range / 2)});
                        continue next;
                    }
                }
            }
            answer[value]++;
        }
        return answer;
    }
}