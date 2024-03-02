class Solution {
    public int[] solution(int[] arr) {
        int n = 0;
        
        while (Math.pow(2, n) - arr.length < 0) {
            n++;
        }
        int[] answer = new int[(int) Math.pow(2, n)];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }
}