class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 1; i <= Math.sqrt(yellow) ; i++){
            if(yellow % i == 0 && (brown - (i * 2)) % 2 == 0){
                answer[0] = (yellow / i) + 2;
                answer[1] = total / answer[0];
                if(answer[0] * answer[1] == total) break;
            }
        }
        return answer;
    }
}