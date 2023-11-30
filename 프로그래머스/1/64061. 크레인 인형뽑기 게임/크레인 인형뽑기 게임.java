class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] result = new int[moves.length];
        int pointer = 0;
        for(int move : moves){
            for(int[] line : board){
                int item = line[move - 1];
                if(item != 0){
                    line[move - 1] = 0;
                    if(result[pointer] == 0){
                        result[pointer] = item;
                    }else if(result[pointer] != item){
                        pointer++;
                        result[pointer] = item;
                    }else{
                        result[pointer] = 0;
                        answer += 2;
                        if(pointer != 0) {
                            pointer--;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}