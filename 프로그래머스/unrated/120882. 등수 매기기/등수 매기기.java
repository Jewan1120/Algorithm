class Solution {
    public int[] solution(int[][] score) {
        float[][] avg = new float[score.length][2];
        for(int i = 0; i < score.length; i++){
            avg[i][0] = (score[i][0] + score[i][1]) / 2f;
            avg[i][1] = i;
        }
        for(int i = 0; i < avg.length - 1; i ++){
            for(int j =0; j < avg.length - 1 - i; j++){
                if(avg[j][0] < avg[j+1][0]){
                    float[] tmp = avg[j];
                    avg[j] = avg[j + 1];
                    avg[j + 1] = tmp;
                }
            }
        }
        int[] rank = new int[score.length];
        rank[0] = 1;
        int count =1;
        for(int i = 1; i < rank.length; i++){
            if(avg[i][0] == avg[i -1][0]){
                rank[i] = rank[i -1];
                count++;
            } else {
                rank[i] = rank[i -1] + count;
                count =1;
            }
        }
        int[] answer = new int[score.length];
        for(int i = 0; i < rank.length; i++){
            answer[(int) avg[i][1]] = rank[i];
        }
        return answer;
    }
}