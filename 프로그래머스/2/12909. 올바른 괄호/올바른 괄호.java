import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(stk.empty() && c == ')') return false;
            if(c == '(') stk.push(c);
            else stk.pop();
        }
        if(stk.size() == 0 ) answer = true;
        return answer;
    }
}