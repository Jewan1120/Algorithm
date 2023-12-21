class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            storey = Math.abs(storey);
            int deci = (int) Math.pow(10, (int) Math.log10(storey));
            int n = storey / deci == 5 ? (int) Math.round((double) storey / deci) : storey / deci;
            if (n > 5) {
                storey -= deci * 10;
                answer++;
            } else {
                storey -= n * deci;
                answer += n;
            }
        }
        return answer;
    }
}