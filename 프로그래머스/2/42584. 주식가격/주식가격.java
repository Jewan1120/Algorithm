import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = n - 1 - i;
        }
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && prices[stk.peek()] >= prices[i])
                stk.pop();
            if (!stk.isEmpty())
                answer[i] -= n - 1 - stk.peek();
            stk.push(i);
        }
        return answer;
    }
}