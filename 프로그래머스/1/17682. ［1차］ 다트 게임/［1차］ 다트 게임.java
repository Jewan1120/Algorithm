class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] scoreArr = dartResult.split("[SDT][*#]?");
        String[] optArr = dartResult.split("\\d+");
        int[] score = new int[4];
        for(int i = 1; i < optArr.length; i++){
            score[i] = Integer.parseInt(scoreArr[i -1]);
            for(char c : optArr[i].toCharArray()){
                switch(c){
                    case 'D':
                        score[i] = (int)Math.pow(score[i],2);
                        break;
                    case 'T':
                        score[i] = (int)Math.pow(score[i],3);
                        break;
                    case '*':
                        score[i - 1] *= 2;
                        score[i] *= 2;
                        break;
                    case '#':
                        score[i] *= -1;
                        break;
                }
            }
        }
        for(int i : score){
            answer += i;
        }
        return answer;
    }
}