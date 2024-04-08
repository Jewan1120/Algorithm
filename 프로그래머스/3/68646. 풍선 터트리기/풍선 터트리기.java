class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        int[] leftBursts = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                leftBursts[i]++;
            }
        }
        
        int[] rightBursts = new int[n];
        min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < min) {
                min = a[i];
                rightBursts[i]++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (leftBursts[i] == 1 || rightBursts[i] == 1) {
                answer++;
            }
        }
        return answer;
    }
}