import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int []> stock = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            int[] stockArr = {prices[i], prices.length - 1 - i};
            answer[i] = stockArr[1];
            if(stock.isEmpty() || stock.peek()[0] <= stockArr[0]){
                stock.push(stockArr);
            }else{
                while(!stock.isEmpty() && stock.peek()[0] > stockArr[0]){
                    int[] tmp = stock.pop();
                    answer[prices.length - 1 - tmp[1]] = tmp[1] - stockArr[1];
                }
                stock.push(stockArr);
            }
        }
        return answer;
    }
}