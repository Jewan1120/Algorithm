class Solution {
    public int solution(String[] strArr) {
        
        int[][] count = {};
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < strArr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < count.length; j++) {
                if (strArr[i].length() == count[j][0]) {
                    count[j][1]++;
                    flg = true;
                    break;
                }
            }
            if (!flg) {
                int[][] tmp = new int[count.length + 1][2];
                System.arraycopy(count, 0, tmp, 0, count.length);
                tmp[count.length][0] = strArr[i].length();
                tmp[count.length][1]++;
                count = tmp;
            }
        }
        for (int[] arr : count) {
            max = arr[1] > max ? arr[1] : max;
        }
        return max;
    }
}