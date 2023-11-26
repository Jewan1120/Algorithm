class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        next: for(int i = 1; i <= number; i++){
            int count = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    count += 2;
                    if(j * j == i){
                        count--;
                    }
                    if(count > limit){
                        answer += power;
                        continue next;
                    }
                }
            }
            answer += count;
        }
        return answer;
    }
}