class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] player = new int[N + 1];
        int playerNum = stages.length;
        for(int i : stages){
            player[i - 1]++;
        }
        float[][] ratio = new float[N][2];
        for(int i = 0; i < N; i++){
            ratio[i][0] = i + 1;
            ratio[i][1] = (float) player[i] / playerNum;
            playerNum -= player[i];
        }
        for(int i = 0; i < ratio.length - 1; i++){
            for(int j = 0; j < ratio.length - i - 1; j++){
                if(ratio[j][1] < ratio[j + 1][1]){
                    float[] tmp = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tmp;
                }
            }
        }
        for(int i = 0; i < ratio.length; i ++){
            answer[i] = (int) ratio[i][0];
        }
        return answer;
    }
}