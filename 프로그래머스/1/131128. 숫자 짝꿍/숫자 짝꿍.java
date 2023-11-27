class Solution {
    public String solution(String X, String Y) {
        int[] numbersX = new int[10];
        int[] numbersY = new int[10];
        for(int i = 0; i < X.length(); i++){
            numbersX[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); i++){
            numbersY[Y.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            sb.append(String.valueOf(i).repeat(Math.min(numbersX[i], numbersY[i])));
        }
        if(sb.length() == 0){
            sb.append(-1);
        }
        return sb.toString().replaceAll("^0+", "0");
    }
}