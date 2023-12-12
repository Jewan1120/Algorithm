import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        Deque<String> deq = new ArrayDeque<String>();
        int index = 0;
        for(char c = 'A'; c <= 'Z'; c++) dict.put(String.valueOf(c), ++index);
        for(String str : msg.split("")) deq.add(str);
        while(!deq.isEmpty()){
            StringBuilder sb1 = new StringBuilder(deq.pollFirst());
            while(dict.containsKey(sb1.toString())){
                StringBuilder sb2 = new StringBuilder(sb1.toString());
                sb2.append(deq.peek());
                if(dict.containsKey(sb2.toString())) sb1.append(deq.poll());
                else{
                    dict.put(sb2.toString(), ++index);
                    int[] tmp = new int[answer.length + 1];
                    System.arraycopy(answer, 0, tmp, 0, answer.length);
                    tmp[answer.length] = dict.get(sb1.toString());
                    answer = tmp;
                    break;
                }
            }
        }
        return answer;
    }
}