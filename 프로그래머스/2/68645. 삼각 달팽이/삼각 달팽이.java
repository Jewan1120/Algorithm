class Solution {
    public int[] solution(int n) {
        int len = 0, num = 0, index = 0, count = 0;
        for(int i = 1; i <= n; i++) len += i;
        int[] answer = new int[len];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                switch(i % 3){
                    case 0:
                        index += count++;
                        break;
                    case 1:
                        index++;
                        break;
                    case 2:
                        index -= count--;
                        break;
                }
                answer[index] = ++num;
            }
        }
        return answer;
    }
}