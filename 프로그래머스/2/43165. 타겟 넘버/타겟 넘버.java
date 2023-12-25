import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numbers.length; i++){
            if(que.isEmpty()){
                que.add(numbers[i]);
                que.add(-numbers[i]);
            }else{
                Queue<Integer> tmp = new LinkedList<>();
                while(!que.isEmpty()){
                    int n = que.poll();
                    tmp.add(n + numbers[i]);
                    tmp.add(n - numbers[i]);
                }
                que = tmp;
            }
        }
        for(Integer i : que){
            if(i == target) answer++;
        }
        return answer;
    }
}