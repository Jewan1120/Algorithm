class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        int highScore = 0;
        for(int i = 0; i < answers.length; i++){
            if(p1[i % p1.length] == answers[i]){
                score[0]++;
            }
            if(p2[i % p2.length] == answers[i]){
                score[1]++;
            }
            if(p3[i % p3.length] == answers[i]){
                score[2]++;
            }
            if(highScore < score[0] || highScore < score[1] || highScore < score[2]){
                highScore++;
            }
        }
        int[] answer = {};
        for(int i =0; i < score.length; i++){
            if(score[i] == highScore){
                int[] tmp = new int[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = i + 1;
                answer = tmp;
            }
        }
        return answer;
    }
}