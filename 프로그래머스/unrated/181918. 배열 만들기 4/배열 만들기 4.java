class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        for (int i = 0; i < arr.length; i++) {
            if (stk.length == 0) {
                stk = new int[] {arr[i]};
            } else if (stk[stk.length - 1] < arr[i]) {
                int[] tmp = new int[stk.length + 1];
                System.arraycopy(stk, 0, tmp, 0, stk.length);
                tmp[stk.length] = arr[i];
                stk = tmp;
            } else {
                int[] tmp = new int[stk.length - 1];
                System.arraycopy(stk, 0, tmp, 0, tmp.length);
                stk = tmp;
                i--;
            }
        }
        return stk;
    }
}