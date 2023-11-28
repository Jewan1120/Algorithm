class Solution {
    public int solution(int[] nums) {
        int[] arr = {};
        next: for (int i : nums) {
            for (int j : arr) {
                if (i == j) {
                    continue next;
                }
            }
            int[] tmp = new int[arr.length + 1];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            tmp[arr.length] = i;
            arr = tmp;
        }
        return nums.length / 2 < arr.length ? nums.length / 2 : arr.length;
    }
}