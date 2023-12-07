import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            sb = new StringBuilder();
            stk.clear();
            sb.append(s.substring(i));
            sb.append(s.substring(0,i));
            for(int j = 0; j < sb.length(); j++){
                char c = sb.charAt(j);
                if(stk.empty()) stk.push(c);
                else if((stk.peek() == '[' && c == ']') || (stk.peek() == '{' && c == '}') || (stk.peek() == '(' && c == ')')) stk.pop();
                else stk.push(c);
            }
            if(stk.size() == 0) answer++;
        }
        return answer;
    }
}