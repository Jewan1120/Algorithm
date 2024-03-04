import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deq = new LinkedList<>();
        int i;
        for(i = 0; i < k; i++){
            while(!deq.isEmpty() && stones[i] >= stones[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        for(; i < stones.length; i++){
            if(answer > stones[deq.peek()]) answer = stones[deq.peek()];
            while(!deq.isEmpty() && deq.peek() <= i - k){
                deq.removeFirst();
            }
            while(!deq.isEmpty() && stones[i] >= stones[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        if(answer > stones[deq.peek()]) answer = stones[deq.peek()];
        return answer;
    }
}