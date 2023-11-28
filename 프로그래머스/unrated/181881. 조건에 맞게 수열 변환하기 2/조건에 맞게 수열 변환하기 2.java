class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        boolean flg = true;
        while (flg) {
            flg = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    flg = true;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1;
                    flg = true;
                }
            }
            if (flg) {
                answer++;
            }
        }
        return answer;
    }
}