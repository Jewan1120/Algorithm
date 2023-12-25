import java.util.Stack;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0, hp = 0, depth = 0;
        boolean[] visited = new boolean[dungeons.length];
        Stack<boolean[]> stk = new Stack<>();
        stk.push(visited);
        while(!stk.isEmpty()){
            boolean[] tmp = stk.pop().clone();
            hp = k;
            depth = 0;
            for(int i = 0; i < tmp.length; i++){
                if(tmp[i]){
                    hp -= dungeons[i][1];
                    depth++;
                    if(answer < depth) answer = depth;
                }
            }
            for(int i = 0; i < tmp.length; i++){
                if(!tmp[i] && hp >= dungeons[i][0]){
                    tmp[i] = true;
                    stk.add(tmp.clone());
                    tmp[i] = false;
                }
            }
        }
        return answer;
    }
}