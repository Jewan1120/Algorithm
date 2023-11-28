class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        boolean flg = true;
        while (flg) {
            flg = false;
            for (int i = 0; i < num_list.length; i++) {
                if (num_list[i] != 1) {
                    num_list[i] = num_list[i] % 2 == 0 ? num_list[i] / 2 : (num_list[i] - 1) / 2;
                    answer++;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
        return answer;
    }
}