import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        for(int i = 1; i <= order.length; i++) que.add(i);
        for(int i : order){
            if(!stk.isEmpty()){
                if(i != stk.peek() && !que.isEmpty()){
                    while(i != que.peek()){
                        stk.push(que.poll());
                        if(que.isEmpty()) return answer;
                    }
                    que.poll();
                } else stk.pop();
                answer++;
            }else{
                while(!que.isEmpty() && i != que.peek()) stk.push(que.poll());
                que.poll();
                answer++;
            }
        }
        return answer;
    }
}