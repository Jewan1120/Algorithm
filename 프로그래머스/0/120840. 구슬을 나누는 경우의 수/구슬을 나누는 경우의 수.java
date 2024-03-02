class Solution {
    public int solution(int balls, int share) {
        double answer = 1;
        int r = balls - share < share ? balls - share : share;
        for(int i = 0; i < r; i++){
            answer *= (double)(balls - i) / (r - i);
        }
        return (int)Math.round(answer);
    }
}