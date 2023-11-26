class Solution {
    public long solution(long n) {
        int length = (int) Math.log10(n) + 1;
        int[] arr = new int[length];
        int idx = 0;
        while (n > 0) {
            arr[idx] = (int) (n % 10);
            n /= 10;
            idx++;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }
}