class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int last = 0;
        int range = w * 2 + 1;
        for (int station : stations) {
            int l = station - w;
            int r = station + w;
            if (last + 1 < l) {
                int len = l - last - 1;
                answer += (len / range);
                if (len % range > 0) {
                    answer++;
                }
            }
            last = r;
        }
        answer += (n - last) / range;
        if ((n - last) % range > 0) {
            answer++;
        }
        return answer;
    }
}