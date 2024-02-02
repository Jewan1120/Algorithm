class Solution {
    public int solution(int n) {
        if(n % 2 == 1) return 0;
        long[] arr = new long[n / 2];
        arr[0] = 3;
        long sum = 0;
        for(int i = 1; i < arr.length; i++){
            arr[i] = (arr[i - 1] * 3 + (sum * 2 + 2)) % 1_000_000_007;
            sum += arr[i - 1];
        }
        return (int)arr[arr.length - 1];
    }
}