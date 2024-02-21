class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] num = {a, b, c, d};
        int[][] dice = {};

        next: for (int i = 0; i < num.length; i++) {
            if (dice.length == 0) {
                dice = new int[][] {{num[i], 1}};
            } else {
                for (int j = 0; j < dice.length; j++) {
                    if (dice[j][0] == num[i]) {
                        dice[j][1]++;
                        continue next;
                    }
                }
                int[][] tmp = new int[dice.length + 1][2];
                System.arraycopy(dice, 0, tmp, 0, dice.length);
                tmp[dice.length][0] = num[i];
                tmp[dice.length][1]++;
                dice = tmp;
            }
        }
        int answer = 1;
        switch (dice.length) {
            case 1:
                answer = dice[0][0] * 1111;
                break;
            case 2:
                if (dice[0][1] == 2) {
                    answer = (dice[0][0] + dice[1][0]) * Math.abs(dice[0][0] - dice[1][0]);
                } else if (dice[0][1] == 3) {
                    answer = (int) Math.pow((10 * dice[0][0]) + dice[1][0], 2);
                } else {
                    answer = (int) Math.pow((10 * dice[1][0]) + dice[0][0], 2);
                }
                break;
            case 3:
                for (int i = 0; i < dice.length; i++) {
                    if (dice[i][1] == 1) {
                        answer *= dice[i][0];
                    }
                }
                break;
            case 4:
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < dice.length; i++) {
                    if (min >= dice[i][0]) {
                        min = dice[i][0];
                    }
                }
                answer = min;
                break;
        }
        return answer;
    }
}