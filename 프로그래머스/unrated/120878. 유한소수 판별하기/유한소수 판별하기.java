class Solution {
    public int solution(int a, int b) {    
        int answer = 1;
        for (int cd = a <= b ? a : b; cd > 0; cd--) {
            if (a % cd == 0 && b % cd == 0) {
                a /= cd;
                b /= cd;
                break;
            }
        }
        while (b > 1) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else {
                answer = 2;
                break;
            }
        }
        return answer;
    }
}