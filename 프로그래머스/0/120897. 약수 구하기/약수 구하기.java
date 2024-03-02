class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                int[] tmp = new int[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = i;
                answer = tmp;
            }
        }
        return answer;
    }
}