class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];
        prime[0] = true; // 0
        prime[1] = true; // 1
        for(int i = 2; i < prime.length; i++){
            if(!prime[i]){
                answer++;
                for(int j = i + i; j < prime.length; j += i){
                    prime[j] = true;
                }
            }
        }
        return answer;
    }
}