import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            int ft = 0;
            int bk = 0;
            Queue<Integer> ftQue = new LinkedList<>();
            Queue<Integer> bkQue = new LinkedList<>();
            ftQue.add(wires[i][0]);
            bkQue.add(wires[i][1]);
            boolean[] check = new boolean[n + 1];
            while(!ftQue.isEmpty()){
                int node = ftQue.poll();
                if(check[node]) continue;
                check[node] = true;
                ft++;
                for(int j = 0; j < wires.length; j++){
                    if(i == j) continue;
                    if(node == wires[j][0]) ftQue.add(wires[j][1]);
                    else if(node == wires[j][1]) ftQue.add(wires[j][0]);
                }
            }
            while(!bkQue.isEmpty()){
                int node = bkQue.poll();
                if(check[node]) continue;
                check[node] = true;
                bk++;
                for(int j = 0; j < wires.length; j++){
                    if(i == j) continue;
                    if(node == wires[j][0]) bkQue.add(wires[j][1]);
                    else if(node == wires[j][1]) bkQue.add(wires[j][0]);
                }
            }
            if(Math.abs(ft - bk) < answer) answer = Math.abs(ft - bk);
        }
        return answer;
    }
}