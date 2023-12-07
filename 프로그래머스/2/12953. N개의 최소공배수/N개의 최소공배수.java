class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for(int i = arr.length -1; i >= 0; i--){
            if(answer % arr[i] != 0){
                int tmp = answer;
                while(tmp % arr[i] != 0 || tmp % answer != 0) tmp++;
                answer = tmp;
            } 
        }
        return answer;
    }
}