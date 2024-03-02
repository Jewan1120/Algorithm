class Solution {
    public int solution(int[] array) {
        int[][] numCount = {};
        count: for (int i = 0; i < array.length; i++) {
            if (numCount.length == 0) {
                numCount = new int[][] {{array[0], 1}};
                continue;
            }
            for (int j = 0; j < numCount.length; j++) {
                if (array[i] == numCount[j][0]) {
                    numCount[j][1]++;
                    continue count;
                }
            }
            int[][] tmp = new int[numCount.length + 1][2];
            System.arraycopy(numCount, 0, tmp, 0, numCount.length);
            tmp[numCount.length][0] = array[i];
            tmp[numCount.length][1] = 1;
            numCount = tmp;
        }
        for (int i = 0; i < numCount.length - 1; i++) {
            for (int j = 0; j < numCount.length - i - 1; j++) {
                if (numCount[j][1] < numCount[j + 1][1]) {
                    int[] tmp = numCount[j];
                    numCount[j] = numCount[j + 1];
                    numCount[j + 1] = tmp;
                }
            }
        }
        return numCount.length == 1 || numCount[0][1] != numCount[1][1] ? numCount[0][0] : -1;
    }
}