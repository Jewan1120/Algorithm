import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> ham = new Stack<Integer>();
        Stack<Integer> tmp = new Stack<Integer>();
        for (int i : ingredient) {
            if (i == 1 && ham.size() >= 3) {
                for (int j = 0; j < 3; j++) {
                    if (ham.peek() != 3 - j) {
                        break;
                    }
                    tmp.add(ham.pop());
                }
                if (tmp.size() == 3) {
                    tmp.clear();
                    answer++;
                    continue;
                }
                while (!tmp.empty()) {
                    ham.add(tmp.pop());
                }
            }
            ham.add(i);
        }
        return answer;
    }
}