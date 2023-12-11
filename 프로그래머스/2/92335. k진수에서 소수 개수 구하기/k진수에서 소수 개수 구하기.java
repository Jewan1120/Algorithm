class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] arr = str.split("0+");
        next: for(String numStr : arr){
            long num = Long.parseLong(numStr);
            if(num == 1) continue;
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0) continue next;
            }
            answer++;
        }
        return answer;
    }
}