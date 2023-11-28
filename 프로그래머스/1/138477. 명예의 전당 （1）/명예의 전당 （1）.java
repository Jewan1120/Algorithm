class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] awards = new int[k + 1];
        int point = k;
        for(int n = 0; n < score.length; n++){
            awards[0] = score[n];
            for(int i =0; i < awards.length - 1; i++){
                for(int j = 0; j < awards.length - i - 1; j++){
                    if(awards[i] > awards[i + 1]){
                        int tmp = awards[i];
                        awards[i] = awards[i + 1];
                        awards[i + 1] = tmp;
                    }
                }
            }
            answer[n] = awards[point];
            if(n < k - 1){
                point--;
            }
        }
        return answer;
    }
}