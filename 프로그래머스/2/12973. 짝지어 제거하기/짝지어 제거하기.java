import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        for(Character c : s.toCharArray()){
            if(stk.empty() || stk.peek() != c) stk.push(c);
            else stk.pop();
        }
        return stk.size() == 0 ? 1 : 0;
    }
}