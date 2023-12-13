class Solution {
    int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        int[] maxArr = land[0].clone();
        for(int i = 1; i < land.length; i++){
            int[] tmp = maxArr.clone();
            for(int j = 0; j < land[0].length; j++){
                int max = Integer.MIN_VALUE;
                for(int k = 0; k < maxArr.length; k++){
                    if(j == k) continue;
                    else if(tmp[k] > max) max = tmp[k];
                }
                maxArr[j] = land[i][j] + max;
            }
        }
        for(int i : maxArr) if(i > answer) answer = i;
        return answer;
    }
}