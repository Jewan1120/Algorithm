import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] opers = {{"*", "+", "-"}, {"*", "-", "+"}, {"+", "*", "-"}, {"+", "-", "*"}, {"-", "*", "+"}, {"-", "+", "*"}};
        Deque<String> deq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] cArr = expression.toCharArray();
        for(int i = 0; i < cArr.length; i++){
            char c = cArr[i];
            if(Character.isDigit(c)){
                sb.append(c);
                if(i == cArr.length - 1) deq.add(sb.toString());
            }else{
                deq.add(sb.toString());
                deq.add(String.valueOf(c));
                sb = new StringBuilder();
            }
        }
        for(String[] oper : opers){
            int index = 0;
            Deque<String> tmpDeq = new ArrayDeque<>();
            tmpDeq.addAll(deq);
            while(tmpDeq.size() > 1){
                String str = tmpDeq.poll();
                if(tmpDeq.peek().equals(oper[index])){
                    long x = Long.parseLong(str);
                    String operStr = tmpDeq.poll();
                    Long y = Long.parseLong(tmpDeq.poll());
                    switch(operStr){
                        case "*":
                            tmpDeq.addFirst(String.valueOf(x * y));
                            break;
                        case "+":
                            tmpDeq.addFirst(String.valueOf(x + y));
                            break;
                        case "-":
                            tmpDeq.addFirst(String.valueOf(x - y));
                            break;
                    }
                }else{
                    tmpDeq.add(str);
                    String chk = tmpDeq.peek();
                    if(chk.equals("*") || chk.equals("+") || chk.equals("-")) tmpDeq.add(tmpDeq.poll());
                    else index++;
                }
            }
            long result = Math.abs(Long.parseLong(tmpDeq.poll()));
            if(answer < result) answer = result;
        }
        return answer;
    }
}