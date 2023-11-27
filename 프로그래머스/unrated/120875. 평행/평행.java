class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int dot1 = 0;
        int dot2 = 0;
        int[][] points = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
        for (int[] point : points) {
            double d1 = ((double) (dots[point[0]][1] - dots[point[1]][1])
                    / (dots[point[0]][0] - dots[point[1]][0]));
            double d2 = ((double) (dots[point[2]][1] - dots[point[3]][1])
                    / (dots[point[2]][0] - dots[point[3]][0]));
            if (d1 == d2) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}