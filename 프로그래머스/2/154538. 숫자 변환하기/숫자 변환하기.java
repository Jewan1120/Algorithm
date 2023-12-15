import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        Queue<Integer> tmp = new LinkedList<Integer>();
        que.add(y);
        while(que.peek() != x){
            int i = que.poll();
            if(i % 3 == 0 && i / 3 >= x) tmp.add(i / 3);
            if(i % 2 == 0 && i / 2 >= x) tmp.add(i / 2);
            if(i - n >= x) tmp.add(i - n);
            if(que.isEmpty()){
                if(tmp.isEmpty()){
                    answer = -1;
                    break;
                }
                que.addAll(tmp);
                answer++;
                tmp.clear();
            }
        }
        return answer;
    }
}