class Solution {
    public int solution(int[][] lines) {
        int lineMin = 100;
        int lineMax = -100;
        int count = 0;
        int answer = 0;
        for(int[] line : lines){
            if(lineMin > line[0]){
                lineMin = line[0];
            }
            if(lineMax < line[1]){
                lineMax = line[1];
            }
        }
        for(int dot = lineMin; dot < lineMax; dot++){
            count = 0;
            for(int[] line : lines){
                if(line[0] <= dot && dot + 1 <= line[1]){
                    count++;
                }
            }
            if(count >= 2){
                answer ++;
            }
        }
        return answer;
    }
}