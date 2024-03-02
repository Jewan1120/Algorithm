class Solution {
    public int solution(int[] num_list) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                sumOdd += num_list[i];
            } else {
                sumEven += num_list[i];
            }
        }
        return sumOdd >= sumEven ? sumOdd : sumEven;
    }
}