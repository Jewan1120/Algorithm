class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i ++){
            int s = Math.max(commands[i][0], commands[i][1]);
            int e = Math.min(commands[i][0], commands[i][1]);
            int[] tmpArr = new int[s - e + 1];
            System.arraycopy(array, e -1, tmpArr, 0, tmpArr.length);
            for(int j = 0; j < tmpArr.length -1; j++){
                for(int k = 0; k < tmpArr.length - j - 1; k++){
                    if(tmpArr[k] > tmpArr[k +1]){
                        int tmp = tmpArr[k];
                        tmpArr[k] = tmpArr[k + 1];
                        tmpArr[k + 1] = tmp;
                    }
                }
            }
            answer[i] = tmpArr[commands[i][2] - 1];
        }
        return answer;
    }
}