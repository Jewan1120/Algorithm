import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stk = new Stack<>();
        for(int i = 0; i < answer.length; i++){
            int[] tmp = {numbers[i], i};
            answer[i] = -1;
            while(!stk.isEmpty() && stk.peek()[0] < tmp[0]) answer[stk.pop()[1]] = tmp[0];
            stk.push(tmp);
        }
        return answer;
    }
}