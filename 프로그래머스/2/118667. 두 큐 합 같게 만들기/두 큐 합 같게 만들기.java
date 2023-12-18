import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long s1 = 0;
        long s2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i ++){
            q1.add(queue1[i]);
            s1 += queue1[i];
            q2.add(queue2[i]);
            s2 += queue2[i];
        }
        while(s1 != s2){
            if(s1 > s2){
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
            }else{
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
            if(answer == queue1.length * 3){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}