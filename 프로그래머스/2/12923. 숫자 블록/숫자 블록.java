class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        for (int i = 0; i < answer.length; i++) {
            if (begin == 1 && i == 0) {
                answer[i] = 0;
                continue;
            }
            long n = begin + i;
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    if(n / j > 10000000){
                        answer[i] = j;
                        continue;
                    }
                    answer[i] = (int) (n / j);
                    break;
                }
            }
            if (answer[i] == 0) {
                answer[i] = 1;
            }
        }
        return answer;
    }
}